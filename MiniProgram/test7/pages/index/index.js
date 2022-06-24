// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    myCard:true
  },

  /**
* 打电话给紧急联系人
*/
  makeCall: function () {
    let tel = this.data.myCard.tel;

    if(tel!=''){
      wx.makePhoneCall({
        phoneNumber: tel
      })
    }
  },
  /**
 * 跳转表单页面
 */
  goToForm: function () {
    wx.navigateTo({
      url: '/pages/form/form'
    })
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
    //尝试读取本地缓存
    let myCard = wx.getStorageSync('myCard');
    //更新data中的myCard
    this.setData({myCard:myCard});
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