<template>
  <div class="line" v-if="fatherindex > 0">
    <a-divider></a-divider>
  </div>
  <div v-if="isDataLoaded" class="template">
    <h2
      class="title-theme"
      v-if="Index < 1 && fatherprimarycourse && fatherindex < 1"
    >
      {{ fatherprimarycourse }}
    </h2>
    <div class="father-theme" v-if="Index < 1">
      {{ first }}
    </div>
    <div class="cardlist" v-for="(item, index) in courselist" :key="index">
      <h2 class="two-title-theme" v-if="fatherindex == 1 && index < 1">
        {{ updateIndex(index, item.parentcourse) }}
      </h2>
      <h2 class="two-title-theme" v-else-if="fatherindex == 2 && index < 1">
        {{ updateIndex(index, item.parentcourse) }}
      </h2>
      <div class="context">
        <div class="card-items">
          <div class="card-item">
            <div class="image">
              <img :src="item.imageurl" alt="" />
              <span class="text">
                <h2 class="classname">{{ item.subcourse }}</h2>
                <span class="little-description"
                  >{{ item.numberofcourses }}个小节</span
                >
                <span class="little-description"
                  ><icon-user />{{ item.numberoflearners }}</span
                >
                <span class="little-description"
                  ><icon-heart />{{ item.numberoffavorites }}</span
                >
              </span>
            </div>
            <div class="description">{{ item.coursedescription }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  

<script setup>
import { ref, onMounted } from "vue";
import useCourseStore from "@/stores/modules/course";
import { storeToRefs } from "pinia";
const course = useCourseStore();
const { pythonlist } = storeToRefs(course);
const isDataLoaded = ref(false);
onMounted(() => {
  if (pythonlist.value && pythonlist.value.length > 0) {
    isDataLoaded.value = true;
  }
});

const props = defineProps({
  courselist: {
    type: Array,
    default: () => [],
  },
  fatherindex: {
    type: Number,
    default: () => 0,
  },
  fatherprimarycourse: {
    type: String,
    default: () => "",
  },
  first: {
    type: String,
    default: () => "",
  },
});
const Index = ref(0);
const first = ref(props.first);
const updateIndex = (currentIndex, parentcourse) => {
  Index.value = currentIndex;
  first.value = parentcourse; // 更新 first 的值
};
</script>
  
  
<style lang="less" scoped>
.cardlist {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  .card-item {
    transition: transform 0.3s ease;
    &:hover {
      transform: translateY(-5px);
    }
  }
}
.arco-divider-horizontal {
  margin: 0;
}
.line {
  padding-bottom: 20px;
  background: rgb(255, 255, 255);
}
.title-theme {
  margin-bottom: 25px;
  width: 1015px;
  background: rgb(243, 245, 246);
  font-size: 16px;
  color: #1c1f21;
  line-height: 54px;
  font-weight: 700;
  margin-bottom: 16px;
  height: 54px;
}
img {
  max-width: 42px;
  max-height: 42px;
}
.template {
  display: flex;
  flex-wrap: wrap;
  width: 1015px;
  background: rgb(255, 255, 255);
  .father-theme {
    font-size: 16px;
    color: #37f;
    line-height: 24px;
    padding-left: 30px;
    padding-bottom: 30px;
    width: 100%;
  }
  .cardlist {
    background: rgb(255, 255, 255);
    .context {
      width: 338px;
      .card-items {
        padding: 0px 30px 30px 30px;
        width: 278px;
        position: relative;
        background: rgb(255, 255, 255);
        .card-item {
          width: 278px;
          height: 78px;
          .image {
            margin-bottom: 8px;
          }
          .text {
            float: right;
            width: 222px;
            height: 50px;
            .classname {
              margin-bottom: 8px;
              font-weight: 700;
              font-size: 16px;
            }
            .little-description {
              margin-right: 8px;
            }
          }
          .description {
            font-size: 12px;
            color: #909090;
            line-height: 20px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
          }
        }
      }
    }
  }
}
</style>