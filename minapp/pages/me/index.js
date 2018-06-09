// pages/me/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height:0,
    userInfo:null,
  },
   
  bindGetUserInfo: function (e) {
    this.setData({
      userInfo: e.detail.userInfo
    })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let _this = this;
    wx.getSystemInfo({
      success: function (res) {
        _this.setData({
          height: res.windowHeight
        })
      },
    });
    // 查看是否授权
    wx.getSetting({
      success: function (res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success: function (res) {
              _this.setData({
                userInfo: res.userInfo
              })
            }
          })
        } else {
          console.log(res);
        }
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  /**
   * 我的发布页面
   */
  toMyReleasePage(e){
    console.log(e);
    let type = e.currentTarget.dataset.type;
    wx.navigateTo({
      url: 'myReleased/index?type='+type,
    })
  },
  
  /**
   * 发布
   */
  release(){
    wx.navigateTo({
      url: 'release/index',
    })
  },
  
  /**
   * 提现
   */
  toCashPage(e){
    wx.navigateTo({
      url: 'cash/index',
    })
  }
})