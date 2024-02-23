import {
  getcourselist,
  getAllfathertitle,
} from "@/service/modules/course";
import { defineStore } from "pinia/dist/pinia";

const useCourseStore = defineStore("courseStore", {
  state: () => ({
    courselist: [],
    parentCourselist: [],
    primarycourselist: [],
    Allfathertitlelist: [],
    frontendlist: [[], []],
    pythonlist: [[], []],
    javalist: [[], [], []],
    databaselist: [],
    backendlist: [[], [], []],
  }),
  actions: {
    async fetchAllCourselist() {
      const res = await getcourselist();
      this.courselist = res.context;
      // Iterate through courselist and add unique parentCourse to parentCourselist
      this.courselist.forEach((course) => {
        const parentCourse = course.parentcourse;
        const primarycourse = course.primarycourse;
        // Check if parentCourse is not already in parentCourselist
        if (!this.parentCourselist.includes(parentCourse)) {
          this.parentCourselist.push(parentCourse);
        }
        if (!this.primarycourselist.includes(primarycourse)) {
          this.primarycourselist.push(primarycourse);
        }
      });
    },
    async fetchAllfathertitlelist() {
      const Allfathertitle = await getAllfathertitle();
      this.Allfathertitlelist.push(Allfathertitle.context);
      for (
        let index = 0;
        index < Allfathertitle.context.frontend.length;
        index++
      ) {
        const element = Allfathertitle.context.frontend[index].parentcourse;
        if (element === "JavaScript") {
          this.frontendlist[0].push(Allfathertitle.context.frontend[index]);
        } else {
          this.frontendlist[1].push(Allfathertitle.context.frontend[index]);
        }
      }
      for (
        let index = 0;
        index < Allfathertitle.context.python.length;
        index++
      ) {
        const element = Allfathertitle.context.python[index].parentcourse;
        if (element === "基础应用") {
          this.pythonlist[0].push(Allfathertitle.context.python[index]);
        } else {
          this.pythonlist[1].push(Allfathertitle.context.python[index]);
        }
      }
      for (let index = 0; index < Allfathertitle.context.java.length; index++) {
        const element = Allfathertitle.context.java[index].parentcourse;
        if (element === "基础应用") {
          this.javalist[0].push(Allfathertitle.context.java[index]);
        } else if (element === "框架应用") {
          this.javalist[1].push(Allfathertitle.context.java[index]);
        } else {
          this.javalist[2].push(Allfathertitle.context.java[index]);
        }
      }
      this.databaselist.push(Allfathertitle.context.database)
      for (
        let index = 0;
        index < Allfathertitle.context.backend.length;
        index++
      ) {
        const element = Allfathertitle.context.backend[index].parentcourse;
        if (element === "服务器") {
          this.backendlist[0].push(Allfathertitle.context.backend[index]);
        } else if (element === "开发工具") {
          this.backendlist[1].push(Allfathertitle.context.backend[index]);
        } else {
          this.backendlist[2].push(Allfathertitle.context.backend[index]);
        }
      }
    },
  },
});

export default useCourseStore;
