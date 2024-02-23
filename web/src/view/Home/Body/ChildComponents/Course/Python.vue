<!-- ParentComponent.vue -->
<template>
  <div class="python">
    <CardTemplate
      v-for="(group, index) in pythonlist"
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
const { pythonlist } = storeToRefs(course);
const primarycourse = ref("python");
const fatherfirst = ref("基础应用");
</script>
  