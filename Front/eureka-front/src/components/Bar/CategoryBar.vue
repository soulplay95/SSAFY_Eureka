<template>
  <div>
        <!-- :menu-dimension="{height: 400, width: 300}" 메뉴 크기 조정 -->
    <FloatMenu
        :position="'top middle'"
        :dimension="50"
        :menu-data="items"
        :on-selected="handleSelection"
        :theme="{
          primary: '#21bf73',
          textColor: '#21bf73',
          menuBgColor: '#b0eacd',
          textSelectedColor: '#1c9e60',
        }"
      >
    category
    </FloatMenu>
  </div>
</template>

<script>
import axios from 'axios'
import { FloatMenu } from "vue-float-menu";
import "vue-float-menu/dist/vue-float-menu.css";

export default {
  data: function() {
    return {
      depthOne: null,
      depthTwo: null,
      depthThree: null,
      items: [],
    }
  },
  components: {
    FloatMenu,
  },
  created: function () {
    axios({
      method: 'get',
      url: `http://localhost/home/category/list`,
    }).
      then(res =>{
        this.depthOne = res.data['1depth']
        this.depthTwo = res.data['2depth']
        this.depthThree = res.data['3depth']
        for (let i = 0; i < this.depthOne.length; i++){
          this.items.push(
            {'name': this.depthOne[i].category_1depth,
             'subMenu': {
               'name': String(this.depthOne[i].category_code),
               'items': []
             }}
          )
        }
        for (let i = 0; i < this.depthTwo.length; i++){
          const tmp = String(this.depthTwo[i].category_code).substring(0,1)
          for (let j = 0; j < this.depthOne.length; j++){
            if (this.items[j]['subMenu']['name'] === tmp){
              this.items[j]['subMenu']['items'].push(
                {
                  'name': this.depthTwo[i].category_2depth,
                  'subMenu': {
                  'name': String(this.depthTwo[i].category_code),
                  'items': []
                }}
              )
              break;
            }
          }
        }
        for (let i = 0; i < this.depthThree.length; i++){
          const tmp1 = String(this.depthThree[i].category_code).substring(0,1)
          const tmp2 = String(this.depthThree[i].category_code).substring(0,2)
          for (let j = 0; j < this.depthOne.length; j++){
            if (this.items[j]['subMenu']['name'] === tmp1){
              for (let k = 0; k < this.items[j]['subMenu']['items'].length; k++){
                if (this.items[j]['subMenu']['items'][k]['subMenu']['name'] === tmp2){
                  this.items[j]['subMenu']['items'][k]['subMenu']['items'].push({
                    'name': this.depthThree[i].category_3depth
                  })
                }
              }
            }
          }
        }
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<style>

</style>