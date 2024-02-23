<template>
  <div class="context">
    <courselist v-if="isDataLoaded" />
  </div>
</template>

<script setup>
import useCourseStore from "@/stores/modules/course";
import { storeToRefs } from "pinia";
import Courselist from "./ChildComponents/Courselist.vue";
import { ref, onMounted } from "vue";
const course = useCourseStore();
const {
  courselist,
} = storeToRefs(course);
const isDataLoaded = ref(false);

onMounted(async () => {
  try {
    // 执行相应的请求
    await Promise.all([
      course.fetchAllCourselist(),
      course.fetchAllfathertitlelist(),
    ]);

    // 所有请求完成后将 isDataLoaded 设置为 true
    isDataLoaded.value = true;
  } catch (error) {
    console.error("Error fetching data:", error);
    // 在错误的情况下，你可能也想将 isDataLoaded 设置为 true，以便正常渲染其余的页面内容
  }
});
</script>


<style  lang="less" scoped>
.context {
  border: none !important;
  background: #f3f5f6;
  width: 1300px;
  margin: 0 auto;
  display: flex;
  height: 100%;
}
</style>
