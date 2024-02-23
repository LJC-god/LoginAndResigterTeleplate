import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/index.js";
import pinia from "../src/stores/index.js";
// import ArcoVueIcon from "@arco-design/web-vue/es/icon";
import "../src/assets/font/font.css";
import "../src/assets/css/index.css";
import "normalize.css";

const app = createApp(App);
app.use(router);
app.use(pinia);
// app.use(ArcoVueIcon);
app.mount("#app");

console.log(process.env.NODE_ENV);
