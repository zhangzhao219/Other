import { createApp } from 'vue'
// import App from './App.vue'
// import App from './components/01globalreg/App.vue'
// import sw from './components/01globalreg/swiper.vue'
import myheader from './components/final/myHeader.vue'
import App from './components/final/App.vue'

const app = createApp(App)
// app.component(sw.name,sw)
app.component('myheader',myheader)
app.mount('#app')