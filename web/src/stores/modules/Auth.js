// authStore.js
import { createPinia } from "pinia";

const { store, defineStore } = createPinia();

export const useAuthStore = defineStore({
  id: "auth",
  state: () => ({
    isAuthenticated: false,
    user: null,
  }),
  actions: {
    login(user) {
      this.isAuthenticated = true;
      this.user = user;
    },
    logout() {
      this.isAuthenticated = false;
      this.user = null;
    },
  },
});

export default store;
