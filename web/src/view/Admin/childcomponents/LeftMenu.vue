<template>
  <div class="button-bar">
    <a-affix :offsetTop="35">
      <a-menu
        mode="inline"
        :defaultSelectedKeys="['bookPage']"
        showCollapseButton
      >
        <a-page-header
          :style="{ background: 'var(--color-bg-2)' }"
          title="ArcoDesign"
          :show-back="false"
        >
        </a-page-header>
        <a-menu-item
          v-for="item in menu"
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
import BookArea from "./LeftMenuItem/BookArea.vue";
import People from "./LeftMenuItem/People.vue";
import Setting from "./LeftMenuItem/Setting.vue";
import menu from "@/mock/menu";
import { ref } from "vue";
const chooseItem = ref(BookArea);
const components = {
  BookArea,
  People,
  Setting,
};
function ChangePage(item) {
  console.log(item.id);
  chooseItem.value = components[item.id];
}
</script>


<style  scoped>
.button-bar {
  width: 100%;
  /* height: 600px; */
  /* padding: 35px; */
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
  width: 1350px;
  height: 1072px;
}
</style>
