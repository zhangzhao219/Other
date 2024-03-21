<template>
  <div>
    <h3 class="thin" :class="isItalic ? 'italic' : ''">swiper轮播图组件</h3>
    <button @click="isItalic=!isItalic">Italic</button>
  </div>
</template>

<script>
export default {
  name: 'MySwiper',
  data () {
    return {
      isItalic: true
    }
  }
}
</script>

<style lang="less" scoped>
.thin{
    font-weight: 200;
}
.italic{
    font-style: italic;
}
</style>