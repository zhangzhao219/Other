<template>
  <div>
    <h3>这是App.vue组件</h3>
    <p>App中的标签1</p>
    <p>App中的标签2</p>
  </div>
  <myswiper></myswiper>
</template>

<script>
import myswiper from './swiper.vue'
export default {
  name: 'MyApp',
  components:{
    'myswiper':myswiper
  }
}
</script>

<style lang="less" scoped>
p{
  color:red;
}
:deep(.title) {
  color:blue;
}
</style>