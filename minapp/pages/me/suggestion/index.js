// pages/me/suggestion/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    suggestionTypeName:'',
    suggestionType:[
      {
        id:'page',
        value:'页面美化建议'
      },
      {
        id: 'function',
        value: '功能改进'
      },
      {
        id: 'view',
        value: '内容审核不严格'
      },
      {
        id: 'app',
        value: '程序建议'
      },
      {
        id: 'just',
        value: '只是想吐槽'
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
  
  },

  /**
   * 类型选择
   */
  bindPickerChange(e) {
    console.log(e);
    let index = e.detail.value;
    let data = this.data.suggestionType;
    let obj = data[index];
    console.log(obj)
    this.setData({
      suggestionTypeName: obj.value,
    });
  },
})