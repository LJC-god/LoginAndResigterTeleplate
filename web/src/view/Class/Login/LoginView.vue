<template>
  <div class="login-container">
    <div class="login-content">
      <div class="login-image js-tilt" data-tilt>
        <img src="@/assets/img/regsiter.png" alt="IMG" />
      </div>

      <form class="login-form validate-form">
        <h1 class="login-title">用户登录</h1>

        <div class="input-wrap validate-input">
          <input
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
import { ref } from "vue";

const userEmail = ref("");
const userPassword = ref("");
const showSuccessModal = ref(false);

const login = () => {
  console.log("Logging in...");
  // 模拟登录成功后显示弹窗
  showSuccessModal.value = true;
};

const onFocus = () => {
  // 输入框获得焦点时的动画效果
};

const onBlur = () => {
  // 输入框失去焦点时的动画效果
};
</script>
  
  <style lang="less" scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: #9053c7; /* 紫色 */
  background: -webkit-linear-gradient(-135deg, #c850c0, #4158d0); /* Safari 5.1-6.0 */
  background: -o-linear-gradient(-135deg, #c850c0, #4158d0); /* Opera 11.1-12.0 */
  background: -moz-linear-gradient(-135deg, #c850c0, #4158d0); /* Firefox 3.6-15 */
  background: linear-gradient(-135deg, #c850c0, #4158d0); /* 标准的渐变 */
  /* 其他样式不变 */
}
.login-content {
  width: 100%;
  max-width: 400px;
  background: #fff;
  border-radius: 10px;
  padding: 54px 65px 55px 65px;
  animation: fadeIn 0.5s ease; /* 添加淡入动画 */
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.login-image {
  display: flex;
  justify-content: center;
}

.login-image img {
  width: 100%;
  max-width: 200px;
}

.login-title {
  font-family: Poppins-Bold;
  font-size: 24px;
  color: #333;
  line-height: 1.2;
  text-align: center;
  margin-bottom: 48px;
}

.input-field {
  font-family: Poppins-Regular;
  font-size: 15px;
  line-height: 1.5;
  color: #555;
  display: block;
  width: 100%;
  background: #f2f2f2;
  height: 50px;
  border-radius: 25px;
  position: relative;
  transition: background 0.3s; /* 添加输入框背景色过渡效果 */
}

.input-field:focus {
  background: #e6e6e6; /* 输入框获得焦点时的背景色 */
}

.input-symbol {
  font-size: 18px;
  color: #555;
  display: block;
  position: absolute;
  background: transparent;
  width: 100%;
  height: 50px;
  top: 0;
  left: 0;
  padding-left: 15px;
  pointer-events: none;
  transition: all 0.4s;
}

.input-symbol i {
  position: absolute;
  font-size: 18px;
  top: 15px;
  left: 18px;
}

.input-wrap {
  position: relative;
  margin-bottom: 32px;
}

.btn-container {
  display: flex;
  justify-content: center;
}

.login-btn {
  font-family: Poppins-Bold;
  font-size: 15px;
  color: #fff;
  line-height: 1.5;
  text-transform: uppercase;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  height: 50px;
  background: #ff6600; /* 更活力的按钮背景色 */
  border-radius: 25px;
  cursor: pointer;
  transition: background 0.4s; /* 添加按钮背景色过渡效果 */
}

.login-btn:hover {
  background: #ff9933; /* 按钮悬停时的背景色 */
}

.text-center {
  text-align: center;
}

.p-top-12 {
  padding-top: 12px;
}

.p-top-136 {
  padding-top: 136px;
}

.forgot-link {
  color: #333;
}

.register-link {
  color: #333;
}

.arrow-icon {
  margin-left: 5px;
}

/* 登录成功弹窗样式 */
.success-modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
}
</style>
  