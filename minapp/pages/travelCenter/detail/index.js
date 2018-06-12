// pages/travelCenter/detail/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    travelData:{},
    showReplyBox:false,
    showAllTextCont:false
  },
  
  /**
   * 预览图片
   */
  priviewImg(e){
    wx.previewImage({
      current: '../../../images/test/img_1.jpg', // 当前显示图片的http链接
      urls: ['../../../images/test/img_1.jpg','../../../images/test/img_1.jpg'] // 需要预览的图片http链接列表
    })
  },
  
  /**
   * 展开全文
   */
  showAllText(){
    let showAllTextCont = this.data.showAllTextCont;
    this.setData({
      showAllTextCont: !showAllTextCont
    });
  },

  /**
   * 回复内容
   */
  replyMainItem(e) {
    let item = e.currentTarget.dataset.item;
    this.setData({
      showReplyBox: true
    });
  },

  /**
   * 取消回复
   */
  cancelBox(e) {
    this.setData({
      showReplyBox: false
    });
  },

  /**
   * 提交回复
   */
  commitReply(e) {
    this.setData({
      showReplyBox: false
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let item = options.item;
    item = JSON.parse(item);
    wx.setNavigationBarTitle({
      title: item.title,
    });
    this.setData({
      travelData: item
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
  
  }
})