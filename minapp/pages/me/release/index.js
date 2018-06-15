// pages/me/released/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectedType:'tips',
    selectType:[
      {
        id:'tips',
        value:'发布攻略'
      },
      {
        id: 'help',
        value: '发布求助'
      },
      {
        id: 'question',
        value: '提问'
      },
    ],
    tipsType: [
      {
        id: 'onePerson',
        value: '个人游'
      },
      {
        id: 'parental',
        value: '亲子游'
      },
      {
        id: 'lovers',
        value: '情侣游'
      },
      {
        id: 'team',
        value: '团体游'
      },
    ],
    Radioitems:[
      {
        id:'findPerson',
        value:'寻人'
      },
      {
        id: 'findThings',
        value: '寻物'
      },
    ],
    radioReward:[
      {
        id:'yes',
        value:'设置'
      },
      {
        id:'no',
        value:'不设置'
      }
    ],
    region: ['广东省', '广州市', '海珠区'],
    TravelPhonto:[],
    releaseTypeName:'',
    formData:{
       releaseType:'',
       travelArea:'',
       detailAddr:'',
       passPlace:'',
       travelFeel:''
    },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: '发布',
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
   * 类型选择
   */
  bindPickerChange(e){
    console.log(e);
    let index = e.detail.value;
    let data = this.data.selectType;
    let obj = data[index];
    console.log(obj)
    this.setData({
      formData: {
        releaseType: obj.id
      },
      releaseTypeName:obj.value,
      selectedType: obj.id
    });
  },

  /**
   * 地区联动选择
   */
  bindRegionChange(e){
    this.setData({
      formData: {
        travelArea: e.detail.value
      },
    });
  },

  /**
 * 从相册选择照片或拍照
 */
  chooseImg(e) {
    let phontos = this.data.TravelPhonto;
    let self = this;
    wx.chooseImage({
      count: 4, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        console.log(res);
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        let tempFilePaths = res.tempFilePaths;
        phontos.push(tempFilePaths);
        self.setData({
          TravelPhonto: phontos
        });
      }
    })
  },
  
  /**
   * 是否设置激励金
   */
  radioRewardChange(e){
     console.log(e)
  },
  
  /**
   * 求助类型
   */
  radioChange(e){
    console.log(e)
  },
  
  /**
   * 表单提交
   */
  formSubmit(e){
    console.log(e);
  }
})