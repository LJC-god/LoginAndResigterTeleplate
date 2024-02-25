<template>
  <div class="login-container">
    <div class="login-content">
      <form class="login-form validate-form">
        <h1 class="login-title">注册</h1>

        <div class="input-wrap validate-input">
          <input
            id="userInput"
            name="user"
            class="input-field"
            type="text"
            v-model="user"
            placeholder="用户名"
            @focus="onFocus"
            @blur="onBlur"
          />
          <span class="input-symbol">
            <i class="fa fa-user" aria-hidden="true"></i>
          </span>
        </div>

        <div class="input-wrap validate-input">
          <input
            id="emailInput"
            name="email"
            class="input-field"
            type="text"
            v-model="email"
            placeholder="邮箱"
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
          <button class="login-btn" @click.prevent="register">注册</button>
        </div>

        <div class="text-center p-top-12">
          <router-link to="/login"
            >已有账号？立即登录
            <i class="fa fa-long-arrow-right arrow-icon" aria-hidden="true"></i>
          </router-link>
        </div>
      </form>
    </div>

    <!-- 注册成功后的弹窗 -->
    <div v-if="showSuccessModal" class="success-modal">
      <div class="modal-content">
        <p>注册成功！</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";

const user = ref("");
const email = ref("");
const password = ref("");
const showSuccessModal = ref(false);

const register = () => {
  // 模拟注册逻辑
  console.log("Registering...");
  console.log("Username:", user.value);
  console.log("Email:", email.value);
  console.log("Password:", password.value);

  // 模拟注册成功后显示弹窗
  showSuccessModal.value = true;
};

const onFocus = (event) => {
  // 输入框获得焦点时的动画效果
  event.target.placeholder = "";
};

const onBlur = (event) => {
  // 输入框失去焦点时的动画效果
  if (event.target.name === "user") {
    event.target.placeholder = "用户名";
  } else if (event.target.name === "email") {
    event.target.placeholder = "邮箱";
  } else if (event.target.name === "password") {
    event.target.placeholder = "密码";
  }
};

onMounted(() => {
  // 页面加载完成时，将焦点设置到用户名输入框上
  document.getElementById("userInput").focus();
});
</script>

<style  scoped>
@import url("@/assets/css/LoginAndRegister.css");
</style>