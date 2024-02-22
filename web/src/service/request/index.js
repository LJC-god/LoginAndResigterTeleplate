import axios from "axios";
import { BASE_URL, TIMEOUT } from "./config";
import useMainStore from "@/stores/modules/main";
import { store } from "..";
const mainstore = useMainStore(store);

// 创建axios实例
class HYRequest {
  constructor(baseURL, timeout = 10000) {
    this.instance = axios.create({
      baseURL,
      timeout,
    });
    //
    this.instance.interceptors.request.use(
      (config) => {
        mainstore.isLoading = true;
        return config;
      },
      (err) => {
        return err;
      }
    );
    this.instance.interceptors.response.use(
      (config) => {
        mainstore.isLoading = false;
        return config;
      },
      (err) => {
        mainstore.isLoading = false;
        return err;
      }
    );
  }

  request(config) {
    // mainstore.isLoading = true;
    return new Promise((resolve, reject) => {
      this.instance
        .request(config)
        .then((res) => {
          resolve(res.data);
          // mainstore.isLoading = false;
        })
        .catch((err) => {
          reject(err);
          // mainstore.isLoading = false;
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
