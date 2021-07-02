
<template>
<el-form :model="itemRegisterForm" :rules="rules" ref="itemRegisterForm" label-width="120px" class="demo-ruleForm">
  <el-form-item label="상품 브랜드" prop="product_brand">
    <el-input v-model="itemRegisterForm.product_brand"></el-input>
  </el-form-item>
  <el-form-item label="상품명" prop="product_name">
    <el-input v-model="itemRegisterForm.product_name"></el-input>
  </el-form-item>
  <el-form-item label="판매자명" prop="seller_name">
    <el-input v-model="itemRegisterForm.seller_name"></el-input>
  </el-form-item>
  <el-form-item label="카테고리" prop="product_category">
    <el-input v-model="itemRegisterForm.product_category"></el-input>
  </el-form-item>
  <el-form-item label="개수" prop="product_count">
    <el-input v-model="itemRegisterForm.product_count"></el-input>
  </el-form-item>
  <el-form-item label="가격" prop="product_price">
    <el-input v-model="itemRegisterForm.product_price"></el-input>
  </el-form-item>
  <el-form-item label="배송비" prop="product_deliveryprice">
    <el-input v-model="itemRegisterForm.product_deliveryprice"></el-input>
  </el-form-item>
  <el-form-item label="할인율" prop="product_discount">
    <el-input v-model="itemRegisterForm.product_discount"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('itemRegisterForm')">Create</el-button>
    <el-button @click="resetForm('itemRegisterForm')">Reset</el-button>
  </el-form-item>
</el-form>
</template>

<script>
// textarea : [brand, deliveryprice, name, price, seller_name, count, discount, rate ]
// imgform : [img]
// category : [category]
  export default {
    name: 'adminItemForm',
    data() {
      return {
        itemRegisterForm: {
          product_brand: '',
          product_name: '',
          seller_name: '',
          product_category: 0,
          product_count: 0,
          product_price: 0,
          product_deliveryprice: 0,
          product_discount: 0,
        },
        rules: {
          product_brand: [
            { required: true, message: '상품 브랜드를 입력해주세요', trigger: 'blur' },
            { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' }
          ],
          product_name: [
            { required: true, message: '상품명을 입력해주세요', trigger: 'blur' },
          ],
          seller_name: [
            { required: true, message: '판매자명을 입력해주세요', trigger: 'blur' },
          ],
          product_category: [
            { type: 'number', required: true, message: '카테고리 코드(숫자)를 입력해주세요', trigger: 'blur' },
          ],
          product_count: [
            { type: 'number', required: true, message: '상품 갯수를 입력해주세요', trigger: 'change' },
          ],
          product_price: [
            { type: 'number', required: true, message: '상품 가격을 입력해주세요', trigger: 'change' },
          ],
          product_deliveryprice: [
            { type: 'number', required: true, message: '배송비를 입력해주세요', trigger: 'change' },
          ],
          product_discount: [
            { type: 'number', required: true, message: '할인율을 입력해주세요', trigger: 'change' },
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style>

</style>
