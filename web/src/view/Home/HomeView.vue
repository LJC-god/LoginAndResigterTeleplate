<template>
  <div class="layout">
    <a-layout>
      <!-- 头部 -->
      <a-layout-header class="header">
        <header-view></header-view>
        <!-- <a-divider class="half-divider" /> -->
      </a-layout-header>
      <!-- 内容 -->
      <a-layout>
        <body-view>
          <a-layout-sider width="1150px" theme="dark">Sider</a-layout-sider>
          <a-layout-content>Content</a-layout-content>
        </body-view>
      </a-layout>
      <!-- 底部 -->
      <a-layout-footer>
        <footer-view></footer-view>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup>
import HeaderView from "./Header/HeaderView.vue";
import BodyView from "./Body/BodyView.vue";
import FooterView from "./Footer/FooterView.vue";
import useCourseStore from "@/stores/modules/course";
import { onMounted } from "vue";
const course = useCourseStore();
onMounted(() => {
  course.fetchAllCourselist();
});
</script>


<style lang="less" scoped>
.layout {
  background: #f2f3f5;
  border: none !important;
  height: 100%;
  .header {
    height: 63px;
  }
}
</style>
