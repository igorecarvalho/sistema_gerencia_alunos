import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';
import VueToast from 'vue-toast-notification';


Vue.config.productionTip = false

Vue.use(VueToast, {
    duration: 6000,
    position: 'top-right',
})

new Vue({
    router,
    store,
    vuetify,
    render: h => h(App)
  }).$mount('#app')
