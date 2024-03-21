<template>
  <div>
    <h1>App根组件 --- {{count}}</h1>
    <hr>
    <button @click="count += 1">+1</button>
    <my-counter v-model:number="count"></my-counter>
  </div>
</template>

<script>
import MyCounter from './Counter.vue'
export default {
  name: 'MyApp',
  components: {
    MyCounter
  },
  data(){
    return{
      count:0
    }
  }
}
</script>

<style>
</style>