
<script setup lang="ts">

import { customRef } from 'vue'

function MyRef<T>(value:T){
  return customRef((trank,trigger) => {
      return {
        get(){
          trank();
          return value;
        },
        set(newVal:T){
          value = newVal;
          trigger();
        }
      }
  })
}

var message = MyRef("name");
const changemessage = () => {
  message.value = "name2";
}

</script>

<template>
  <button @click="changemessage">change</button>
  <div >{{message}}</div>
</template>

<style scoped>
</style>
