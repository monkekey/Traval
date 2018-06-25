package com.Travel.butler.web;

import com.Travel.butler.common.RequestResult;
import com.Travel.butler.domain.ReleaseInfo;
import com.Travel.butler.service.ReleaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/***
 * 信息发布 列表获取
 */
@RestController
@RequestMapping("api/release")
@Api(description = "信息发布 列表获取")
public class ReleaseInfoController {

    @Autowired
    private ReleaseInfoService releaseInfoService;

    /**
     * 保存或修改发布信息
     * @param info
     * @return
     */
    @PostMapping("save")
    @ApiOperation("保存或修改信息")
    public RequestResult saveRelease(@RequestBody ReleaseInfo info){
        try{
            info=releaseInfoService.saveRelease(info);
            return RequestResult.success(info);
        }catch (Exception e){
            return RequestResult.fail(e.getMessage());
        }
    }

    @GetMapping("list")
    @ApiOperation("获取列表")
    public RequestResult getPageListByParams(@RequestParam Map<String,Object> params){
        try{
            Page<ReleaseInfo> page = releaseInfoService.getReleaseListPageByParams(params);
            return RequestResult.success(page);
        }catch (Exception e){
            return RequestResult.fail(e.getMessage());
        }
    }
}
