<template>
  <div class="app-container">
    <h1>App根组件</h1>
    <myheader title="黑马程序员" bgcolor='#000' color='red'></myheader>
  </div>
</template>

<script>
import myheader from './myHeader.vue'
export default {
  name: 'myapp'
}
</script>

<style lang="less" scoped>
.app-container{
    margin-top: 45px;
}
</style>