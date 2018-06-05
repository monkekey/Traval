package com.Travel.butler.web;

import com.Travel.butler.common.RequestResult;
import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.*;
import com.Travel.butler.service.InnService;
import com.Travel.butler.service.SysUserService;
import com.Travel.butler.utils.CoodinateCovertor;
import com.Travel.butler.utils.DESHelper;
import com.Travel.butler.utils.LngLat;
import com.Travel.butler.vo.InnVo;
import com.Travel.butler.vo.UserVo;
import com.Travel.netty.tools.StringUtils;
import com.sun.org.apache.regexp.internal.RE;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Leo on 2017/10/9.
 */

@RestController
@RequestMapping("/api/wx")
@Api(value = "WechatController", description = "微信相关接口")
public class WechatController {
    @Value("${storepath.wxacode}")
    private String wxacodeUrl;

    @Autowired
    private IWechataccountRepository iWechataccountRepository;
    @Autowired
    private IWechattokenRepository iWechattokenRepository;
    @Autowired
    private IInnRepository iInnRepository;
    @Autowired
    private IFavoriteRepository iFavoriteRepository;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private IServicesRepository iServicesRepository;
    @Autowired
    private InnService innService;
    @Autowired
    private ISysuserRepository sysuserRepository;
    @Autowired
    private ISysuserdetailRepository sysuserdetailRepository;
    @Autowired
    private ISysuserdetailRepository iSysuserdetailRepository;
    @Autowired
    private IInnRepository innRepository;

    private String page = "pages/index/index";


    @GetMapping("/getOpenId")
    @ApiOperation(value = "WX|获取用户openid")
    public RequestResult getOpenId(@RequestParam(value = "platformCode", required = true, defaultValue = "") String platformCode,
                                   @RequestParam(value = "code", required = true, defaultValue = "") String code){

        Wechataccount wechataccount = iWechataccountRepository.findByPlatformAndFlag(platformCode, CommonFlag.VALID.getValue());
        if(null == wechataccount){
            return RequestResult.fail("没有找到对应的应用数据");
        }

        String appid = wechataccount.getAppId();
        String secret = DESHelper.decrypt(wechataccount.getSecret(), StringUtils.sortByChart(appid.concat("lavandeinn")).substring(0, 8));//wechataccount.getSecret()
        if(StringUtils.isNULL(appid)|| StringUtils.isNULL(secret)){
            return RequestResult.fail("应用数据错误");
        }
//        secret = DESHelper.decrypt(secret, appid.concat("wechat_account").substring(0, 8));

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={APPID}&secret={APPSECRET}&js_code={JSCODE}&grant_type=authorization_code";
        Map<String, String> params = new HashMap<String, String>();
        params.put("APPID",appid);//"wx47823b34812dcbf5");
        params.put("APPSECRET",secret);//"0a5ad3ae285b8673684c5279f8ef28a3");
        params.put("JSCODE",code);
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class, params);


        if(null!=result) {
            JSONObject json = JSONObject.parseObject(result.getBody());

            if(null!=json && !json.containsKey("errmsg")){

                return RequestResult.success(json);
            }
        }

        return RequestResult.fail("获取openid失败!");
    }


    @GetMapping("/getButlerInfo")
    @ApiOperation(value = "WX|获取门店信息以及管家资料")
    public RequestResult getButlerInfo(@RequestParam(value = "inncode", required = true) String inncode,
                                       @RequestParam(value = "openid", required = true) String openid){

        if(StringUtils.isNULL(inncode)){
            return RequestResult.fail("参数有误!");
        }

        List<UserVo> userVoList = sysUserService.findAllUserByInncode(inncode, openid);
        Inn inn = iInnRepository.findByInnCode(inncode);

        //Integer favoriteQty = iFavoriteRepository.countByInnCodeAndAccountAndFlag(inncode, account, CommonFlag.VALID.getValue());
        //Favorite favorite = iFavoriteRepository.findByInnCodeAndAccountAndOpenid(inncode, account, openid);
        //map.put("favoriteQty", favoriteQty);
        //map.put("favorited", (null==favorite ||favorite.getFlag()==CommonFlag.INVALID.getValue()) ? 0 : 1);

        Map<String, Object> map = new HashMap<>();
        map.put("butler", userVoList);
        map.put("inn", inn);

        List<Map<String, String>> notices = new ArrayList<>();
        Map<String, String> noticeMap = new HashMap<>();

        File noticeDict = new File(wxacodeUrl + File.separator + "notice");
        if (noticeDict.isDirectory()){
            for (String noticeFileName : noticeDict.list()){
                if (noticeFileName.lastIndexOf(".") >0 && "PNG,JPG".indexOf(noticeFileName.substring(noticeFileName.lastIndexOf(".") + 1).toUpperCase())>0 ){
                    noticeMap = new HashMap<>();
                    noticeMap.put("url", noticeFileName);
                    noticeMap.put("desc", noticeFileName);
                    notices.add(noticeMap);
                }
            }
        }
        map.put("notices", notices);

        return  RequestResult.success(map);
    }

    @ApiOperation(value = "新增|Favorite")
    @PostMapping("/star")
    @Transactional
    public RequestResult add(@RequestBody Favorite favorite){

        if (StringUtils.isNULL(favorite.getAccount()) || StringUtils.isNULL(favorite.getInnCode()) || StringUtils.isNULL(favorite.getOpenid())){
            return RequestResult.fail("account、openid、inncode不能为空");
        }

        Favorite old_favorite = iFavoriteRepository.findByInnCodeAndAccountAndOpenid(favorite.getInnCode(), favorite.getAccount(), favorite.getOpenid());
        if(null != old_favorite){
            old_favorite.setFlag(favorite.getFlag());
            old_favorite.setCreateTime(new Date());
            iFavoriteRepository.saveAndFlush(old_favorite);
        }else{
            favorite.setCreateTime(new Date());
            iFavoriteRepository.saveAndFlush(favorite);
        }


        return RequestResult.success("ok");
    }


    @GetMapping("/getToken/{platform}")
    @ApiOperation(value = "WX|获取AccessToken")
    public RequestResult getAccessToken(@NotNull @PathVariable("platform") String platform) {
        String token = "";

        Wechataccount wechataccount = iWechataccountRepository.findByPlatformAndFlag(platform, 1);
        if(null == wechataccount){
            return RequestResult.fail("无法获取AppId配置信息");
        }

        Wechattoken wechattoken = iWechattokenRepository.findByAccountIdAndFlag(wechataccount.getId(),1);
        if(wechattoken == null || StringUtils.isNULL(wechattoken.getAccessToken()) || wechattoken.getAccessToken().equalsIgnoreCase("null") || new Date().getTime() > wechattoken.getExpiresTime().getTime()){
            //获取token
            String appid = wechataccount.getAppId();
            String secret = DESHelper.decrypt(wechataccount.getSecret(), StringUtils.sortByChart(appid.concat("lavandeinn")).substring(0, 8));
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}";
            Map<String, String> params = new HashMap<String, String>();
            params.put("APPID",appid);//"wx47823b34812dcbf5");
            params.put("APPSECRET", secret);//wechataccount.getSecret()//"0a5ad3ae285b8673684c5279f8ef28a3");
            ResponseEntity<String> result = restTemplate.getForEntity(url,String.class, params);

            JSONObject json = JSONObject.parseObject(result.getBody());
            token = String.valueOf(json.get("access_token"));

            //判断接口是否正确返回
            if(token != null){
                if(wechattoken == null){
                    wechattoken = new Wechattoken();
                    wechattoken.setAccountId(wechataccount.getId());
                    wechattoken.setFlag(CommonFlag.VALID.getValue());
                }
                wechattoken.setExpiresTime(StringUtils.modifyDate(new Date(), 0, 0, 0, 0, 0, 7000)); //默认2个小时失效，
                wechattoken.setAccessToken(token);
                iWechattokenRepository.saveAndFlush(wechattoken);
            }
        } else {
            token = wechattoken.getAccessToken();
        }

        return RequestResult.success(token);
    }

    @ApiOperation(value = "Services|列表")
    @GetMapping("/getTopService")
    public RequestResult list(@RequestParam(value = "pageIdx", required = false, defaultValue = "0") Integer pageIdx,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, "id");
        return RequestResult.success(iServicesRepository.findByFlagOrderBySortDesc(pageable, 1));
    }

    @ApiOperation(value = "Nearest Inn|最近门店")
    @GetMapping("/getNearstInn")
    public RequestResult getNearestInn(@RequestParam(value = "longitude", required = true) String longitude,
                                       @RequestParam(value = "latitude", required = true) String latitude) {
        LngLat currentPoint = new LngLat(Double.valueOf(longitude), Double.valueOf(latitude));
        currentPoint = CoodinateCovertor.bd_encrypt(currentPoint);

        List<InnVo> innList = innService.findValidInn();
        for (InnVo inn : innList){
            inn.setDistance(CoodinateCovertor.calculateDistance(new LngLat(inn.getLongitude().doubleValue(), inn.getLatitude().doubleValue()), currentPoint));
        }

        Collections.sort(innList);
        return RequestResult.success(innList.size()>0?innList.subList(0,1):new ArrayList<InnVo>());
    }

    /**
     * 本地是否存在该房间二维码图片
     * @return
     */
    public Boolean isExistsFile(String innCode, String roomNo){
        Boolean isExistsFile = false;
        String fileName =  File.separator + "qrcode" + File.separator + innCode + File.separator + roomNo + ".png";
        File saveFile = new File(wxacodeUrl + fileName);
        // 判断这个文件（saveFile）是否存在
        if (saveFile.exists()) {
            isExistsFile = true;
        }

        return isExistsFile;
    }

}
