
<template>
<el-form :model="itemFormInfo" :rules="rules" ref="itemForm" label-width="120px" class="demo-ruleForm">
  <el-form-item label="상품 브랜드" prop="product_brand">
    <el-input v-model="itemFormInfo.product_brand"></el-input>
  </el-form-item>
  <el-form-item label="상품명" prop="product_name">
    <el-input v-model="itemFormInfo.product_name"></el-input>
  </el-form-item>
  <el-form-item label="판매자명" prop="seller_name">
    <el-input v-model="itemFormInfo.seller_name"></el-input>
  </el-form-item>
  <el-form-item label="카테고리(code)" prop="product_category">
    <el-input v-model="itemFormInfo.product_category"></el-input>
  </el-form-item>
  <el-form-item label="개수" prop="product_count">
    <el-input v-model="itemFormInfo.product_count"></el-input>
  </el-form-item>
  <el-form-item label="가격(₩)" prop="product_price">
    <el-input v-model="itemFormInfo.product_price"></el-input>
  </el-form-item>
  <el-form-item label="배송비(₩)" prop="product_deliveryprice">
    <el-input v-model="itemFormInfo.product_deliveryprice"></el-input>
  </el-form-item>
  <el-form-item label="할인율(%)" prop="product_discount">
    <el-input v-model="itemFormInfo.product_discount"></el-input>
  </el-form-item>
  <el-upload
    action="https://jsonplaceholder.typicode.com/posts/"
    list-type="picture-card"
    :on-preview="handlePictureCardPreview"
    :on-remove="handleRemove"
  >
  <i class="el-icon-plus"></i>
  </el-upload>
  <el-dialog v-model="dialogVisible">
    <img width="100%" :src="dialogImageUrl" alt="" />
  </el-dialog>
  <el-form-item>
    <el-button type="primary" @click="submitForm('itemForm')">Create</el-button>
    <el-button @click="resetForm('itemForm')">Reset</el-button>
  </el-form-item>
</el-form>
</template>

<script>
// textarea : [brand, deliveryprice, name, price, seller_name, count, discount, rate ]
// imgform : [img]
// category : [category]

import { mapGetters } from 'vuex'
import http from '@/utils/http-common'
import router from '@/router'

export default {
    name: 'adminItemForm',
    data() {
      return {
        dialogImageUrl: '',
        dialogVisible: false,
        rules: {
          product_brand: [
            { message: '상품 브랜드를 입력해주세요', trigger: 'blur' },
            { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' }
          ],
          product_name: [
            { required: true, message: '상품명을 입력해주세요', trigger: 'blur' },
          ],
          seller_name: [
            { required: true, message: '판매자명을 입력해주세요', trigger: 'blur' },
          ],
          product_category: [
            { required: true, message: '카테고리 코드(숫자)를 입력해주세요', trigger: 'blur' },
          ],
          product_count: [
            { required: true, message: '상품 갯수를 입력해주세요', trigger: 'change' },
          ],
          product_price: [
            { required: true, message: '상품 가격을 입력해주세요', trigger: 'change' },
          ],
          product_deliveryprice: [
            { required: true, message: '배송비를 입력해주세요', trigger: 'change' },
          ],
          product_discount: [
            { required: true, message: '할인율을 입력해주세요', trigger: 'change' },
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.currentMode === "register"){
              this.registerItem()
            } else if (this.currentMode === "modify") {
              this.modifyItem()
            }
          } else {
            console.log('error submit!!')
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
      },
      registerItem() {
        http
          .post('admin/product', this.itemFormInfo)
          .then((res) => {
            console.log(res)
            router.push({name: "AdminItemList"})
          })
      },
      modifyItem() {
        http
          .put('admin/modify', this.itemFormInfo)
          .then((res) => {
            console.log(res)
            router.push({name: "AdminItemList"})
          })
      },
      handleRemove(file, fileList) {
        console.log(file, fileList)
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url
        this.dialogVisible = true
      },
    },
    computed: {
      ...mapGetters('adminStore', ['itemFormInfo', 'currentMode'])
    }
}
</script>

<style>

</style>
