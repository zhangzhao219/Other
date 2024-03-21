<template>
  <div>Counter组件</div>
  <p>Count:{{count}}</p>
  <button @click="add">+1</button>
</template>

<script>
export default {
  name: 'MyCounter',
  emits:['countchange'],
  data () {
    return {
      count: 0,
    }
  },
  methods: {
    add(){
      this.count++;
      this.$emit('countchange',this.count);
    }
  }
}
</script>

<style>
</style>