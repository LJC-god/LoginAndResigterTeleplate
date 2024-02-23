import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("@/view/Foreground/Home.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import("@/view/Foreground/LoginandRegister/Login.vue"),
  },
  {
    path: "/register",
    name: "register",
    component: () => import("@/view/Foreground/LoginandRegister/Register.vue"),
  },
  {
    path: "/layout",
    name: "layout",
    component: () => import("@/components/Layout.vue"),
  },
  {
    path: "/admin",
    name: "admin",
    children: [
      {
        path: "login",
        name: "adminlogin",
        component: () => import("@/view/BackGround/Login/Login.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
