import {createApp} from 'vue'
import router from "@/router/router.js";
import {createPinia} from "pinia";
import App from './App.vue'
import './assets/main.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'

const app = createApp(App);
app.use(router);
app.use(createPinia);
app.mount('#app');