<template>
  <div class="button-bar">
    <a-affix :offsetTop="35">
      <a-menu
        mode="inline"
        :defaultSelectedKeys="['AllPage']"
        showCollapseButton
      >
        <a-menu-item
          v-for="item in bookmenu"
          :key="item.id"
          @click.native="ChangePage(item)"
        >
          <template #icon><icon-apps></icon-apps></template>
          {{ item.name }}
        </a-menu-item>
      </a-menu>
    </a-affix>
    <div class="context">
      <component :is="chooseItem"></component>
    </div>
  </div>
</template>

<script setup>
import AllPage from "./Course/All.vue";
import BackEndPage from "./Course/BackEnd.vue";
import FrontEndPage from "./Course/FrontEnd.vue";
import JavaPage from "./Course/Java.vue";
import PythonPage from "./Course/Python.vue";
import SqlPage from "./Course/Sql.vue";
import bookmenu from "@/mock/bookmenu";
import { ref } from "vue";
import { shallowRef } from "vue";
const chooseItem = shallowRef(AllPage);

const components = {
  AllPage,
  BackEndPage,
  FrontEndPage,
  JavaPage,
  PythonPage,
  SqlPage,
};

function ChangePage(item) {
  console.log(item.id);
  chooseItem.value = components[item.id];
}

</script>



<style  lang="less" scoped>
.button-bar {
  width: 100%;
  /* height: 600px; */
  padding: 35px;
  display: flex;
  box-sizing: border-box;
  background-color: var(--color-neutral-2);
}
.button-bar .arco-menu {
  width: 200px;
  /* height: 100%; */
  box-shadow: 0 0 1px rgba(0, 0, 0, 0.3);
}
.button-bar .arco-menu :deep(.arco-menu-collapse-button) {
  width: 32px;
  height: 32px;
  border-radius: 50%;
}
.button-bar
  .arco-menu:not(.arco-menu-collapsed)
  :deep(.arco-menu-collapse-button) {
  right: 0;
  bottom: 8px;
  transform: translateX(50%);
}
.button-bar .arco-menu:not(.arco-menu-collapsed)::before {
  content: "";
  position: absolute;
  right: 0;
  bottom: 0;
  width: 48px;
  height: 48px;
  background-color: inherit;
  border-radius: 50%;
  box-shadow: -4px 0 2px var(--color-bg-2), 0 0 1px rgba(0, 0, 0, 0.3);
  transform: translateX(50%);
}
.button-bar .arco-menu.arco-menu-collapsed {
  width: 48px;
  height: auto;
  padding-top: 24px;
  padding-bottom: 138px;
  border-radius: 22px;
}
.button-bar .arco-menu.arco-menu-collapsed :deep(.arco-menu-collapse-button) {
  right: 8px;
  bottom: 8px;
}
.context {
  /* width: 20%; */
  float: left;
  padding-left: 50px;
  padding-top: 15px;
  width: 1350px;
  // height: 1072px;
}
</style>
