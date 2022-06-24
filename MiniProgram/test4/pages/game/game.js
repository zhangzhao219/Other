// pages/game/game.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.initial();
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
  initial:function(){
    this.setData({
      answer:Math.round(Math.random() * 100),
      count:0,
      tip:'',
      x:-1,
      isGameStart:true
    });
  },
  getNumber:function (e) {
    this.setData({x:e.detail.value})
  },
  guess:function(){
    let x = this.data.x;
    this.setData({x:-1});
    if(x < 0){
      wx.showToast({
        title: '不能小于0',
      });
    }
    else if(x > 100){
      wx.showToast({
        title: '不能大于100',
      });
    }
    else{
      let count = this.data.count + 1;
      let tip = this.data.tip;
      let answer = this.data.answer;
      if(x == answer){
        tip += '\n第' + count + '回合：' + x + '，猜对了！';
        this.setData({isGameStart:false});
      }
      else if (x > answer){
        tip += '\n第' + count + '回合：' + x + '，大了！';
      }
      else{
        tip += '\n第' + count + '回合：' + x + '，小了！';
      }
      if(count == 8){
        tip += '\n游戏结束';
        this.setData({isGameStart:false});
      }
      this.setData({
        tip:tip,
        count:count
      })
    }
  },
  restartGame:function () {
    this.initial();
  }
})