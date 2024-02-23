<!-- ParentComponent.vue -->
<template>
  <div class="java">
    <CardTemplate
      v-for="(group, index) in backendlist"
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
const { backendlist } = storeToRefs(course);
const primarycourse = ref("服务器相关");
const fatherfirst = ref("服务器");
</script>
  