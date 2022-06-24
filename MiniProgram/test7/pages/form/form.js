// pages/form/form.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    date: '2000-01-01',
    blood: 'A型',
    bloodItems: ['A型', 'B型', 'O型', 'AB型'],
    ylzk:'无',
    ylbj:'无',
    gmfy:'无',
    yy:'无',
    qgjz:false,
    height:'170cm',
    weight: '50kg',
    tel:'10086'
  },

  /**
 * 提交表单
 */
  submitForm: function (e) {
    //console.log(e);
    //let myCard = e.detail.value;
    wx.setStorageSync('myCard', e.detail.value);
    //返回首页
    wx.navigateBack();
  },
  /**
 * 删除急救卡信息
 */
  delMyCard: function (e) {
    wx.removeStorageSync('myCard');
    //返回首页
    wx.navigateBack();
  },
  /**
   * 更新出生日期
   */
  dateChange: function(e) {
    this.setData({
      date: e.detail.value
    });
  },

  /**
   * 更新出生日期
   */
  bloodChange: function(e) {
    let i = e.detail.value;
    this.setData({
      blood: this.data.bloodItems[i]
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    //尝试获取本地缓存
    let myCard = wx.getStorageSync('myCard');
   //更新数据
    if(myCard!=''){
      this.setData({
        date: myCard.date,
        blood: myCard.blood,
        ylzk: myCard.ylzk,
        ylbj: myCard.ylbj,
        gmfy: myCard.gmfy,
        yy: myCard.yy,
        qgjz: myCard.qgjz,
        height: myCard.height,
        weight: myCard.weight,
        tel: myCard.tel
      })

    }

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})