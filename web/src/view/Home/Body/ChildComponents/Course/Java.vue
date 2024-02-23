<!-- ParentComponent.vue -->
<template>
  <div class="java">
    <CardTemplate
      v-for="(group, index) in javalist"
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
const { javalist } = storeToRefs(course);
const primarycourse = ref("java");
const fatherfirst = ref("基础应用");
</script>
  