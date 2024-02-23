<template>
  <div class="menu">
    <div class="menuitems">
      <ul v-for="item in keyList" :key="item.key">
        <li class="item">
          <router-link :to="item.link">{{ item.context }}</router-link>
        </li>
      </ul>
    </div>
    <div class="headerright">
      <div class="search">
        <img class="svg" src="../../../assets/icon/search.svg" alt="search" />
      </div>
      <div class="shopping">
        <router-link to="/home/shopping">
          <img
            class="svg"
            src="../../../assets/icon/shopping.svg"
            alt="shopping"
          />
        </router-link>
      </div>
      <div class="login-register">
        <router-link to="/home/login">
          <img class="svg" src="../../../assets/icon/login.svg" alt="login" />
        </router-link>
        <router-link to="/home/register">
          <img
            class="svg"
            src="../../../assets/icon/register.svg"
            alt="register"
          />
        </router-link>
      </div>
    </div>
  </div>
</template>
  
  <script setup>
import { ref } from "vue";
const keyList = ref([
  { key: 1, context: "慕课网首页", link: "/home" },
  { key: 2, context: "免费课", link: "/class/free" },
  { key: 3, context: "实战课", link: "/class/combat" },
  { key: 4, context: "体系课", link: "/class/system" },
  { key: 5, context: "成长课", link: "/class/grow" },
  { key: 6, context: "发现", link: "/class/discover" },
  { key: 7, context: "商业合作", link: "/class/business" },
]);
</script>
    
<style lang="less" scoped>
.menu {
  box-sizing: border-box;
  width: 1152px;
  height: 63px;
  margin: 0 auto;
  .menuitems {
    margin: 0 auto;
    text-align: center;
  }
  .item {
    height: 63px;
    float: left;
    line-height: 63px;
    padding: 0 16px;
  }
  .headerright {
    float: right;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    height: 63px;
    .svg {
      width: 30px;
      height: 30px;
      line-height: 63px;
      padding: 20px;
    }
  }
}
.half-divider {
  margin: 5px;
}
.TopSearch {
  background: #fff;
  box-shadow: 0 2px 4px 0 rgba(28, 31, 33, 0.06);
  height: 54px;
  margin-top: 10px;
  padding: 8px 0;
}
</style>
