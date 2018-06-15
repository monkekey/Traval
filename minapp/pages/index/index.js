var Zan = require('../../zanui/index')

const pageData ={

  /**
   * 页面的初始数据
   */
  data: {

    height: 0,
    tab:{
      list:[{
        id: 0,
        title:'攻略'
      },{
        id: 1,
        title: '求助'
      },{
        id: 2,
        title: '问答'
      }]
    },
    selectedId: 0,
    travleData: [
      {
        id: '1234567989',
        attachment: [
          '../../images/test/img_1.jpg'
        ],
        browseNum: '145',
        replyNum: '60',
        upvoteNum: '87',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        tags: [
          {
            id: 'lovers',
            value: '情侣游'
          },
          {
            id: 'team',
            value: '团体游'
          },
        ],
        createTime: "2018-05-23 12:23",
        content: "我们时间较充足，所以计划的是5天深度游玩三亚。全程连住四星级酒店4晚、门票、交通、当地导游费、吃饭等全都包含了,不留遗憾的是: 三亚必玩景点蜈支洲岛、妈祖庙、情人桥、观日岩、生命井、亚龙湾、椰梦长廊、天堂国家森林公园、天涯海角、南海观音都去过了，真正的感受到了海南之蓝，梦镜般的旅行。",
        title: '三亚自由行攻略'
      },
      {
        id: '1234567989',
        attachment: [
          '../../images/test/img_1.jpg'
        ],
        browseNum: '145',
        replyNum: '60',
        upvoteNum: '87',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        tags: [
          {
            id: 'lovers',
            value: '情侣游'
          },
          {
            id: 'team',
            value: '团体游'
          },
        ],
        createTime: "2018-05-23 12:23",
        content: "我们时间较充足，所以计划的是5天深度游玩三亚。全程连住四星级酒店4晚、门票、交通、当地导游费、吃饭等全都包含了,不留遗憾的是: 三亚必玩景点蜈支洲岛、妈祖庙、情人桥、观日岩、生命井、亚龙湾、椰梦长廊、天堂国家森林公园、天涯海角、南海观音都去过了，真正的感受到了海南之蓝，梦镜般的旅行。",
        title: '三亚自由行攻略'
      },
      {
        id: '1234567989',
        attachment: [
          '../../images/test/img_1.jpg'
        ],
        browseNum: '145',
        replyNum: '60',
        upvoteNum: '87',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        tags: [
          {
            id: 'lovers',
            value: '情侣游'
          },
          {
            id: 'team',
            value: '团体游'
          },
        ],
        createTime: "2018-05-23 12:23",
        content: "我们时间较充足，所以计划的是5天深度游玩三亚。全程连住四星级酒店4晚、门票、交通、当地导游费、吃饭等全都包含了,不留遗憾的是: 三亚必玩景点蜈支洲岛、妈祖庙、情人桥、观日岩、生命井、亚龙湾、椰梦长廊、天堂国家森林公园、天涯海角、南海观音都去过了，真正的感受到了海南之蓝，梦镜般的旅行。",
        title: '三亚自由行攻略'
      },
    ],
    helpData:[
      {
        id:'123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward:null,
        flag:2
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
    questionData: [
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "去北欧看北极光，哪个国家更好",
        title: '北欧在哪里看北极光',
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "去北欧看北极光，哪个国家更好",
        title: '北欧在哪里看北极光',
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "去北欧看北极光，哪个国家更好",
        title: '北欧在哪里看北极光',
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "去北欧看北极光，哪个国家更好",
        title: '北欧在哪里看北极光',
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "去北欧看北极光，哪个国家更好",
        title: '北欧在哪里看北极光',
      },
    ]
  },

  /**
   * 攻略详情页
   */
  toTravelDetailPage(e) {
    console.log(e);
    let item = e.currentTarget.dataset.item;
    item = JSON.stringify(item);
    wx.navigateTo({
      url: '../travelCenter/detail/index?item='+item,
    })
  },

  /**
   * 跳转到详情页
   */
  toDetailPage(e) {
    let item = e.currentTarget.dataset.item;
    item = JSON.stringify(item);
    wx.navigateTo({
      url: '../helpCenter/detail/index?item=' + item,
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
    let componentId="tab";
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
  lower: function (e) {
    
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
    
  },
  searchChange(){
    wx.navigateTo({
      url: '../search/index'
    })
  }

}

Page(Object.assign(pageData, {}, Zan.Tab))