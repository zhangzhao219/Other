<template>
  <div>
    <h1>App根组件</h1>
    <hr>
    <my-counter @countchange="getCount"></my-counter>
  </div>
</template>

<script>
import MyCounter from './Counter.vue'
export default {
  name: 'MyApp',
  components: {
    MyCounter
  },
  methods: {
    getCount (val) {
      console.log(val);
    }
  }
}
</script>

<style>
</style>