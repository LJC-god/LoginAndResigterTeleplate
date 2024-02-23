<template>
  <div>
    <div class="list-title">{{ parentcourse.value }}</div>
    <div class="list-cards">
      <div v-for="(item, index) in courselist" :key="index" class="card-item">
        <div class="title">{{ item.subcourse }}</div>
        <div class="meta">
          <div class="describe">{{ item.coursedescription }}</div>
          <div class="course-info">
            <span class="course-count"> 课程数: {{ item.numberofcourses }} </span>
            <span class="comment-count"> 评论: {{ item.numberoflearners }} </span>
            <span class="viewers-count">观看人数: {{ item.numberoffavorites }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import useCourseStore from "@/stores/modules/course";
import { storeToRefs } from "pinia";
import { ref } from "vue";

const course = useCourseStore();
const { courselist } = storeToRefs(course);
const parentcourse = ref([]);
</script>

<style lang="less" scoped>
.list-cards {
  display: flex;
  flex-wrap: wrap;
}

.card-item {
  width: 278px;
  height: 78px;
  margin-bottom: 14px;
  margin-right: 14px;
}

.list-title {
  font-size: large;
  color: blue;
}

.title {
  /* 子标题的样式 */
  color: black;
}

.meta {
  /* 其他 meta 相关的样式 */
  color: black;
}
</style>
