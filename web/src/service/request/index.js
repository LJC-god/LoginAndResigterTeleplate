import axios from "axios";
import { BASE_URL, TIMEOUT } from "./config";
import useMainStore from "@/stores/modules/main.js";
import { store } from "..";
const mainstore = useMainStore(store);

// 创建axios实例 拦截器
class HYRequest {
  // 在类的构造函数中，使用axios.create()方法创建一个axios实例，并将baseURL和timeout作为配置传递进去。然后将创建的实例赋值给this.instance属性。
  constructor(baseURL, timeout = 10000) {
    this.instance = axios.create({
      baseURL,
      timeout,
    });
    // 在axios实例上使用interceptors.request.use()方法添加一个请求拦截器。该拦截器在每次请求发送前执行一些操作，例如将mainstore.isLoading设置为true来显示加载状态。之后返回请求配置对象。
    this.instance.interceptors.request.use(
      (config) => {
        console.log("请求参数：", config);
        mainstore.isLoading = true;
        return config;
      },
      (err) => {
        return err;
      }
    );
    // 在axios实例上使用interceptors.response.use()方法添加一个响应拦截器。该拦截器在每次收到响应后执行一些操作，例如将mainstore.isLoading设置为false来隐藏加载状态。之后返回响应配置对象。
    this.instance.interceptors.response.use(
      (config) => {
        console.log("返回结果:", config);
        mainstore.isLoading = false;
        return config;
      },
      (err) => {
        console.log("返回错误:", err);
        mainstore.isLoading = false;
        return err;
      }
    );
  }
  // 定义request()方法，用于发送请求。这个方法返回一个Promise对象，在内部使用axios实例的request()方法发送请求，并在请求成功后通过resolve()方法返回响应数据，请求失败后通过reject()方法返回错误信息。
  request(config) {
    return new Promise((resolve, reject) => {
      this.instance
        .request(config)
        .then((res) => {
          resolve(res.data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
  // get请求
  get(config) {
    return this.request({ ...config, method: "get" });
  }
  // post请求
  post(config) {
    return this.request({ ...config, method: "post" });
  }
}

export default new HYRequest(BASE_URL, TIMEOUT);
