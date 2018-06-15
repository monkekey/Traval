// pages/search/index.js
var model = require('../../Area/model.js')
var show = false;
var item = {};


Page({

  /**
   * 页面的初始数据
   */
  data: {
  
    height: 0,
    width:0,
    item: {
      show: show
    },
    consume: [
      { name: 0, value: '经济行', checked: 'true' },
      { name: 1, value: '享受行' }
    ],
    accompany: [
      { name: 0, value: '个人游', checked: 'true' },
      { name: 1, value: '情侣游' },
      { name: 2, value: '亲子游' },
      { name: 3, value: '团体游' }
    ],
    loading: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
    let _this = this
    wx.getSystemInfo({
      success: function (res) {
        _this.setData({
          height: res.windowHeight,
          width: res.windowWidth
        })
      }
    });

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function (e) {
    var that = this;
    //请求数据
    model.updateAreaData(that, 0, e);
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
  //点击选择城市按钮显示picker-view
  translate: function (e) {
    model.animationEvents(this, 0, true, 400);
  },
  //隐藏picker-view
  hiddenFloatView: function (e) {
    model.animationEvents(this, 200, false, 400);
  },
  //滑动事件
  bindChange: function (e) {
    model.updateAreaData(this, 1, e);
    item = this.data.item;
    this.setData({
      province: item.provinces[item.value[0]].name,
      city: item.citys[item.value[1]].name,
      county: item.countys[item.value[2]].name
    });
  },
  radioChange: function (e) {
    let _this = this
    let value = parseInt(e.detail.value)
    _this.setData({
      recleaning: value
    })
  },
  consumeChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value)
  },
  accompanyChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value)
  }
})