// pages/helpCenter/index.js
var Zan = require('../../zanui/index')

const pageData={

  /**
   * 页面的初始数据
   */
  data: {
    height: 0,
    tab: {
      list: [{
        id: 0,
        title: '同城求助'
      }, {
        id: 1,
        title: '我发布的'
      }, {
        id: 2,
        title: '我领取的'
      }]
    },
    selectedId: 0,
    helpData: [
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: null,
        flag: 2
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: null,
        flag: 3
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: 10,
        flag: 3
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: null,
        flag: 2
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: 520,
        flag: 2
      },
    ],
    selectType: [
      {
        id: 'reward',
        value: '悬赏求助'
      },
      {
        id: 'parental',
        value: '求助中'
      },
      {
        id: 'lovers',
        value: '已完成'
      },
    ],
  },
  
  /**
   * 跳转到详情页
   */
  toDetailPage(e){
    let item = e.currentTarget.dataset.item;
    item = JSON.stringify(item);
    wx.navigateTo({
      url: 'detail/index?item='+item,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let _this = this
    wx.getSystemInfo({
      success: function (res) {
        _this.setData({
          height: res.windowHeight
        })
      },
    });
    let componentId = "tab";
    _this.setData({
      [`${componentId}.selectedId`]: 0
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
  handleZanTabChange(e) {
    console.log(e);
    var componentId = e.componentId;
    var selectedId = e.selectedId;
    this.setData({
      [`${componentId}.selectedId`]: selectedId,
      selectedId: selectedId
    });
    let num = selectedId
    let _this = this

  }
}
Page(Object.assign(pageData, {}, Zan.Tab))