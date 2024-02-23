import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    redirect: "/home",
  },
  {
    path: "/home",
    name: "home",
    component: () => import("../view/Home/HomeView.vue"),
  },
  {
    path: "/home/register",
    name: "register",
    component: () => import("../view/Class/Register/RegisterView.vue"),
  },
  {
    path: "/home/shopping",
    name: "shopping",
    component: () => import("../view/Class/Shopping/ShoppingView.vue"),
  },
  {
    path: "/home/login",
    name: "login",
    component: () => import("../view/Class/Login/LoginView.vue"),
  },
  {
    path: "/class/free",
    name: "free",
    component: () => import("../view/Class/Free/FreeView.vue"),
  },
  {
    path: "/class/combat",
    name: "combat",
    component: () => import("../view/Class/Combat/CombatView.vue"),
  },
  {
    path: "/class/system",
    name: "system",
    component: () => import("../view/Class/System/SystemView.vue"),
  },
  {
    path: "/class/grow",
    name: "grow",
    component: () => import("../view/Class/Grow/GrowView.vue"),
  },
  {
    path: "/class/discover",
    name: "discover",
    component: () => import("../view/Class/Discover/DiscoverView.vue"),
  },
  {
    path: "/class/business",
    name: "business",
    component: () => import("../view/Class/Business/Business.vue"),
  },
  {
    path: "/admin",
    name: "admin",
    component: () => import("../view/Admin/Admin.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
