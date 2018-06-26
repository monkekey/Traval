const Request = require('../../../utils/RequestUtil.js');
const lavandeAPI = require('../../../api/LavandeAPI.js')

Page({

  /**
   * 页面的初始数据
   */
  data: {
    onLoading:false,
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
    travelPhonto:[],
    helpPhonto:[],
    releaseTypeName: '',
    releaseType: '',
    travelType: '',
    travelArea: '',
    helpType:'',
    isReward:'',
    formData:{
       detailAddr:'',
       passAddr:'',
       travelFeel:'',
       title:'',
       detaileAddr:'',
       rewardMoney:'',
       remark:'',
       content:'',
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
    let index = e.detail.value;
    let data = this.data.selectType;
    let obj = data[index];
    this.setData({
      releaseType: obj.id,
      releaseTypeName: obj.value,
      selectedType: obj.id
    });
  },
  
  /**
   * 攻略类型选择
   */
  checkboxChange(e){
    this.setData({
      travelType: e.detail.value,
    });
  },

  /**
   * 地区联动选择
   */
  bindRegionChange(e){
    this.setData({
      travelArea: e.detail.value
    });
  },

  /**
 * 从相册选择照片或拍照
 */
  chooseImg(e) {
    let selectedType = this.data.selectedType;
    let self = this;
    wx.chooseImage({
      count: 4, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        console.log(res);
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        let tempFilePaths = res.tempFilePaths;
        if ("tips" == selectedType){
          let phontos = self.data.travelPhonto;
          phontos.push(tempFilePaths);
          for (let i = 0; i < tempFilePaths.length;i++){
            wx.uploadFile({
              url: SERVER + "uploadFile/upload",
              filePath: tempFilePaths[i],
              name: 'file',
              success: function (res) {
                console.log(res)
              }
            })
          }
          
          self.setData({
            travelPhonto: phontos
          });
        } else if ("help" == selectedType){
          let phontos = self.data.helpPhonto;
          phontos.push(tempFilePaths);
          self.setData({
            helpPhonto: phontos
          });
        }
      }
    })
  },

  /**
   * 删除一添加的图片
   */
  deleteImg(e){
    console.log(e);
    let selectedType = this.data.selectedType;
    let index = e.target.dataset.index;
    if ("tips" == selectedType) {
      let data = this.data.travelPhonto;
      console.log(data);
      data.splice(index, 1);
      this.setData({
        travelPhonto: data
      });
    } else if ("help" == selectedType) {
      let data = this.data.helpPhonto;
      data.splice(index, 1);
      this.setData({
        helpPhonto: phontos
      });
    }
  },
  /**
   * 是否设置激励金
   */
  radioRewardChange(e){
     this.setData({
       isReward:e.detail.value
     });
  },
  
  /**
   * 求助类型
   */
  radioChange(e){
    this.setData({
      helpType:e.detail.value
    });
  },
  
  /**
   * 表单提交
   */
  formSubmit(e){
    this.setData({
      onLoading:true
    });
    let releaseType = this.data.releaseType;
    let formData = this.data.formData;
    formData.releaseType = releaseType,
    formData.releaseTypeName = this.data.releaseTypeName,
    console.log(e);
    if ("tips" == releaseType){
      formData.travelType = this.data.travelType;
      formData.travelArea = this.data.travelArea;
      formData.travelPhonto = this.data.travelPhonto;
      formData.travelArea = this.data.travelArea;
    } else if ("help" == releaseType){
      formData.helpPhonto = this.data.helpPhonto;
      formData.travelArea = this.data.travelArea;
      formData.helpType = this.data.helpType;
      formData.isReward = this.data.isReward;
    }
    lavandeAPI.saveRelease(formData,(res)=>{
      console.log(res)
    });
  }
})