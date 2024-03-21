<template>
  <div>
    <h1>App根组件</h1>
    <hr>
    <my-count :count="2"
              :state="true"
              :info="'fdsfs'"
              :type="'success'"></my-count>
  </div>
</template>

<script>
import MyCount from './Count.vue'
export default {
  name: 'MyApp',
  components: {
    MyCount
  }
}
</script>

<style>
</style>