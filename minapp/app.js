const extraApp = require('extraApp.js');
const lavandeAPI = require('api/LavandeAPI.js')

const app = {
  onLaunch: function () {
    this.getUserInfo();
    this.getSystemInfo();
  },

  getUserInfo: function (cb) {
    var that = this;
    //调用登录接口
    wx.login({
      success: function (res) {
        let code = res.code;
        //获取openid 保存用户信息
        lavandeAPI.getOpenId({ platformCode: that.globalData.platformCode, code: code }, function (openIdRes) {
          if (openIdRes.success) {
            console.log(openIdRes);
            let openid = openIdRes.data.openid;
            that.globalData.openid = openid;
            getApp().setWxStorageSync('TravelOpenid', openid);
            // 查看是否授权
            wx.getSetting({
              success: function (res) {
                if (res.authSetting['scope.userInfo']) {
                  // 已经授权，可以直接调用 getUserInfo 获取头像昵称
                  wx.getUserInfo({
                    success: function (userRes) {
                      console.log(userRes);
                      that.globalData.userInfo = userRes.userInfo
                      getApp().setWxStorageSync('TravelUserInfo', userRes.userInfo);
                      userRes.userInfo.openid = openid;
                      lavandeAPI.saveUserInfo(userRes.userInfo,function (result) {
                         console.log(result);
                      })
                    },
                    fail: function (res) {
                      console.log(res);
                      getApp().setWxStorageSync('TravelUserInfo', null);
                    }
                  })
                } else {
                  console.log("没有授权");
                  getApp().setWxStorageSync('TravelUserInfo', null);
                }
              }
            }); 
            typeof cb == "function" && cb(openid)
          }
        });
        
      }, fail: function () {
       
      }
    })
  },
  getSystemInfo: function () {
    var that = this;
    if (!this.globalData.SystemInfo.windowWidth) {
      wx.getSystemInfo({
        success: function (res) {
          that.globalData.SystemInfo = res
        }
      })
    }
  },
  globalData:{
    platformCode: 'Traval', //应用CODE
    userInfo: {},
    openid: '',
    wxUserInfo: {},
    currentInnCode: '',
    currentRoomNo: '',
    SystemInfo: {},
    payMethodList: [{
      name: '到店支付',
      code: 'face',
      class: ''
    }, {
      name: '微信支付',
      code: 'wx',
      class: ''
    }],
    imgUrl: 'http://yumi-icon.oss-cn-shenzhen.aliyuncs.com/wxyumibnb/',
    imghotel: 'http://iyumi-web.oss-cn-shenzhen.aliyuncs.com/',
    payNotifyUrl: 'http://api.iyumi.com/web/booking_order/pay/WXCallBack',
    imgAccuracy: '',
    location: {
      latitude: '',
      longitude: '',
    }
  }
};

App(Object.assign(app, {}, extraApp));