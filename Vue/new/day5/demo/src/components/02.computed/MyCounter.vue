<template>
  <div>
    <input type="text" v-model.number="count">
    <p>{{count}} * 2 = {{plus}}</p>
    <p>{{count}} * 2 = {{plus}}</p>
    <p>{{count}} * 2 = {{plus}}</p>
  </div>
</template>

<script>
export default {
  name: 'MyCounter',
  data(){
    return {
      count:1
    }
  },
  computed:{
    plus(){
      console.log("jisuan")
      return this.count * 2
    }
  },
  // methods:{
  //   plus(){
  //     console.log("fangfa")
  //     return this.count * 2
  //   }
  // }
}
</script>

<style lang="less" scoped>
</style>