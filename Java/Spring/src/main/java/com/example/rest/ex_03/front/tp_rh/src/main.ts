import {createApp} from 'vue';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import './assets/global.css';
import App from './App.vue';
import router from './router/router.ts';

const app = createApp(App);
app.use(router);
app.mount('#app');
