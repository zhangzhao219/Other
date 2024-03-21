<template>
  <h1>这是<i>App.vue</i>根组件</h1>
  <h3>abc -- {{username}}</h3>
  <p>count:{{count}}</p>
  <button @click="addCount">+1</button>
  <my-swiper></my-swiper>
  <my-test></my-test>
  <my-search></my-search>
</template>

<script>
import search from './components/search.vue'

export default {
  name: 'MyApp',
  data () {
    return {
      username: 'zs',
      count: 0
    }
  },
  methods: {
    addCount () {
      this.count++;
    }
  },
  components:{
    'my-search':search
  }
}
</script>

<style lang="less">
h1 {
  color: red;
  i {
    color: blue;
  }
}
</style>