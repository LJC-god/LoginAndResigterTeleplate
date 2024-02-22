import { defineStore } from "pinia/dist/pinia";

//获取当前时间
const startDate = new Date();
const endDate = new Date();
//将时间设置为明天
endDate.setDate(startDate.getDate() + 1);

const useMainStore = defineStore("main", {
  state: () => ({
    token: "",
    startDate: startDate,
    endDate: endDate,
    isLoading: false,
  }),
});

export default useMainStore;
