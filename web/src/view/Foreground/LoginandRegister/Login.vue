<template>
  <div class="login-container">
    <div class="login-content">
      <form class="login-form validate-form">
        <h1 class="login-title">登录</h1>

        <div class="input-wrap validate-input">
          <input
            id="userInput"
            name="user"
            class="input-field"
            type="text"
            v-model="user"
            placeholder="用户"
            @focus="onFocus"
            @blur="onBlur"
          />
          <span class="input-symbol">
            <i class="fa fa-envelope" aria-hidden="true"></i>
          </span>
        </div>

        <div class="input-wrap validate-input">
          <input
            id="passwordInput"
            name="password"
            class="input-field"
            type="password"
            v-model="password"
            placeholder="密码"
            @focus="onFocus"
            @blur="onBlur"
          />
          <span class="input-symbol">
            <i class="fa fa-lock" aria-hidden="true"></i>
          </span>
        </div>

        <div class="btn-container">
          <button class="login-btn" @click.prevent="login">登录</button>
        </div>

        <div class="text-center p-top-136">
          <router-link to="register"
            >还没有账号？立即注册
            <i class="fa fa-long-arrow-right arrow-icon" aria-hidden="true"></i>
          </router-link>
        </div>
      </form>
    </div>

    <!-- 登录成功后的弹窗 -->
    <div v-if="showSuccessModal" class="success-modal">
      <div class="modal-content">
        <p>登录成功！</p>
      </div>
    </div>
  </div>
</template>
  
  <script setup>
import router from "@/router";
import { ref, onMounted } from "vue";
onMounted(() => {
  // 页面加载完成时，将焦点设置到用户输入框上
  document.getElementById("userInput").focus();
});
const user = ref("");
const password = ref("");
const showSuccessModal = ref(false);

const login = () => {
  console.log("Logging in...");
  // 模拟登录成功后显示弹窗
  showSuccessModal.value = true;
  router.push("home")
};

const onFocus = (event) => {
  // 输入框获得焦点时的动画效果
  event.target.placeholder = "";
};

const onBlur = (event) => {
  // 输入框失去焦点时的动画效果
  if (event.target.name === "user") {
    event.target.placeholder = "用户名";
  } else if (event.target.name === "password") {
    event.target.placeholder = "密码";
  }
};
</script>
  
<style  scoped>
@import url("@/assets/css/LoginAndRegister.css");
</style>