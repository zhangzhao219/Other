<template>
  <div>
    <div class="header-container" :style="{backgroundColor:bgcolor,color:color}">
        {{title || 'Header组件'}}
    </div>
  </div>
</template>

<script>
export default {
    name:'myheader',
    props:['title','bgcolor','color']
}
</script>

<style lang="less" scoped>
.header-container{
    height: 45px;
    background-color: pink;
    text-align: center;
    line-height: 45px;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 999;
}
</style>