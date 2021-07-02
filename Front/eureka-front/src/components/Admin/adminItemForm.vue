
<template>
<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
  <el-form-item label="상품 브랜드" prop="product_brand">
    <el-input v-model="ruleForm.product_brand"></el-input>
  </el-form-item>
  <el-form-item label="상품명" prop="product_name">
    <el-input v-model="ruleForm.product_name"></el-input>
  </el-form-item>
  <el-form-item label="판매자명" prop="seller_name">
    <el-input v-model="ruleForm.seller_name"></el-input>
  </el-form-item>
  <el-form-item label="개수" prop="product_count">
    <el-input v-model="ruleForm.product_count"></el-input>
  </el-form-item>
  <el-form-item label="가격" prop="product_price">
    <el-input v-model="ruleForm.product_price"></el-input>
  </el-form-item>
  <el-form-item label="배송비" prop="product_deliveryprice">
    <el-input v-model="ruleForm.product_deliveryprice"></el-input>
  </el-form-item>
  <el-form-item label="할인율" prop="product_discount">
    <el-input v-model="ruleForm.product_discount"></el-input>
  </el-form-item>
  <el-dropdown trigger="click">
    <span class="el-dropdown-link">
    Dropdown List<i class="el-icon-arrow-down el-icon--right"></i>
    </span>
    <template #dropdown>
    <el-dropdown-menu>
        <el-dropdown-item icon="el-icon-plus">Action 1</el-dropdown-item>
        <el-dropdown-item icon="el-icon-circle-plus">Action 2</el-dropdown-item>
        <el-dropdown-item icon="el-icon-circle-plus-outline">Action 3</el-dropdown-item>
        <el-dropdown-item icon="el-icon-check">Action 4</el-dropdown-item>
        <el-dropdown-item icon="el-icon-circle-check">Action 5</el-dropdown-item>
    </el-dropdown-menu>
    </template>
</el-dropdown>
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">Create</el-button>
    <el-button @click="resetForm('ruleForm')">Reset</el-button>
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
        ruleForm: {
          product_brand: '',
          product_name: '',
          seller_name: '',
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
