<!-- ParentComponent.vue -->
<template>
  <div class="frontend">
    <CardTemplate
      v-for="(group, index) in frontendlist"
      :key="index"
      :courselist="group"
      :fatherindex="index"
      :fatherprimarycourse="primarycourse"
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
const { frontendlist } = storeToRefs(course);
const primarycourse = ref("前端开发");
const fatherfirst = ref("JavaScript");
</script>
  