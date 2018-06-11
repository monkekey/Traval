// pages/me/reviewCenter/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    reviewData: [
      {
        id: '1234567989',
        attachment: [
          '../../images/test/img_1.jpg'
        ],
        browseNum: '145',
        replyNum: '60',
        upvoteNum: '87',
        avatar: '../../../images/test/img_5.png',
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
        title: '三亚自由行攻略',
        type:'tips',
        reviewStatu:0
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: null,
        flag: 3,
        type:'help',
        reviewStatu: 2
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: 10,
        flag: 3,
        type:'help',
        reviewStatu: 1
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "5.23日在十字路口看美女，回头就不见了",
        title: '狗狗丢失',
        reward: null,
        flag: 2,
        type:'help',
        reviewStatu: 1
      },
      {
        id: '123456',
        browseNum: '145',
        replyNum: '60',
        avatar: '../../../images/test/img_5.png',
        nickName: '哼哼哈嘿',
        createTime: "2018-05-23 12:23",
        content: "去北欧看北极光，哪个国家更好",
        title: '北欧在哪里看北极光',
        type:'ques',
        reviewStatu: 2
      },
    ],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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
  
  }
})