<template>
  <div class="cart-container">
    <div class="cart-content">
      <h1 class="cart-title">购物车</h1>

      <div v-if="cartItems.length === 0" class="empty-cart-message">
        <p>您的购物车是空的。</p>
      </div>

      <div v-else class="cart-items">
        <div v-for="(item, index) in cartItems" :key="index" class="cart-item">
          <div class="item-info">
            <p>{{ item.name }}</p>
            <p>价格: {{ item.price }}</p>
          </div>
          <div class="item-actions">
            <button @click="removeItem(index)" class="remove-btn">移除</button>
          </div>
        </div>
      </div>

      <div class="btn-container">
        <router-link to="checkout">
          <button v-if="cartItems.length > 0" class="checkout-btn">结算</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const cartItems = ref([
  { name: "商品1", price: 20 },
  { name: "商品2", price: 30 },
  // Add more items here if needed
]);

const removeItem = (index) => {
  cartItems.value.splice(index, 1);
};
</script>

<style lang="less" scoped>
.cart-container {
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
.cart-content {
  width: 100%;
  max-width: 600px;
  background: #fff;
  border-radius: 10px;
  padding: 20px;
}

.cart-title {
  font-family: Poppins-Bold;
  font-size: 24px;
  color: #333;
  line-height: 1.2;
  text-align: center;
  margin-bottom: 20px;
}

.empty-cart-message {
  text-align: center;
  margin-top: 20px;
}

.cart-items {
  margin-top: 20px;
}

.cart-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #ccc;
  padding: 10px 0;
}

.item-info {
  flex: 1;
}

.item-actions {
  flex-shrink: 0;
}

.remove-btn {
  font-size: 14px;
  color: #fff;
  background-color: #f44336; /* 更活力的按钮背景色 */
  border: none;
  padding: 8px 12px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.remove-btn:hover {
  background-color: #d32f2f; /* 按钮悬停时的背景色 */
}

.btn-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.checkout-btn {
  font-size: 16px;
  color: #fff;
  background-color: #333; /* 更活力的按钮背景色 */
  border: none;
  padding: 12px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.checkout-btn:hover {
  background-color: #555; /* 按钮悬停时的背景色 */
}
</style>
