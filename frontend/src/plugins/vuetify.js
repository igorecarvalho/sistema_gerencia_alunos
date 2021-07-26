// src/plugins/vuetify.js

import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import '@mdi/font/css/materialdesignicons.css'
import pt from 'vuetify/es5/locale/pt';

Vue.use(Vuetify)

export default new Vuetify({

    lang: {
        locales: { pt },
        current: 'pt',
    },

    icons: {
        iconfont: 'mdi', // default - only for display purposes
    },
    
})