import {createApp} from 'vue'
import {createPinia} from "pinia";
import router from "@/router/router.js";
import App from './App.vue'
import './assets/main.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'

const app = createApp(App);

app.use(createPinia());
app.use(router);

app.mount('#app');