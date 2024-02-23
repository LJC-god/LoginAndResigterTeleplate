<template>
  <a-table
    v-if="isLoading"
    :columns="columns"
    :data="course.courselist"
    size="mini"
    class="table"
  >
    <template #imageurl="{ record }">
      <img :src="record.imageurl" alt="" />
    </template>
    <template #handle="{ record }">
      <a-button class="delete" @click="DeleteClick(record.id)">delete</a-button>
      <a-button class="compile" @click="CompileClick(record.id)"
        >compile</a-button
      >
    </template>
  </a-table>
</template>

<script setup>
import useCourseStore from "@/stores/modules/course";
import { ref } from "vue";
const course = useCourseStore();
const isLoading = ref(false);
course.fetchAllCourselist().then(() => {
  isLoading.value = true;
});
const columns = [
  {
    title: "image",
    slotName: "imageurl", // key: "pic", // slots: { //   customRender: "pic", // },
  },
  {
    title: "ID",
    dataIndex: "id",
  },
  {
    title: "PrimaryCourse",
    dataIndex: "primarycourse",
  },
  {
    title: "ParentCourse",
    dataIndex: "parentcourse",
  },
  {
    title: "SubCourse",
    dataIndex: "subcourse",
  },
  {
    title: "Courses",
    dataIndex: "numberofcourses",
  },
  {
    title: "Favorites",
    dataIndex: "numberoffavorites",
  },
  {
    title: "Learners",
    dataIndex: "numberoflearners",
  },
  {
    title: "CourseDescription",
    dataIndex: "coursedescription",
  },
  {
    title: "Handle",
    slotName: "handle",
  },
];
function DeleteClick(id) {
  console.log("delete " + id);
}
function CompileClick(id) {
  console.log("compile " + id);
}
</script>
<style  lang="less" scoped>
.table {
  // width: 1350px;
  :deep(arco-table-td-content) {
    font-size: 13px;
  }
  .compile {
    margin: 10px;
  }
  img {
    max-width: 84px;
  }
  :deep(.arco-table-td-content) {
    display: block;
    max-width: 250px;
  }
}
</style>
