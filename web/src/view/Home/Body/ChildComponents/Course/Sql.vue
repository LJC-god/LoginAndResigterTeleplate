<!-- ParentComponent.vue -->
<template>
  <div class="database">
    <CardTemplate
      v-for="(group, index) in databaselist"
      :key="index"
      :courselist="group"
      :fatherindex="index"
      :fatherprimarycourse="primarycourse"
      :isOneDimensional="index === 0"
      :first="fatherfirst"
    ></CardTemplate>
  </div>
</template>
  
  <script setup>
import CardTemplate from "./CardTemplate.vue";
import useCourseStore from "@/stores/modules/course";
import { storeToRefs } from "pinia";
import { ref } from "vue";
const course = useCourseStore();
const { databaselist } = storeToRefs(course);
const primarycourse = ref("数据库");
const fatherfirst = ref("MySQL");
</script>
  