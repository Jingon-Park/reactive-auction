<template>
  <v-container>
    <v-row>
    <div>검색 목록</div>
    <v-row justify="start">
      <ItemInfo v-for="item in items" :key="item" v-bind:item="item"></ItemInfo>
    </v-row>
    
  </v-row>
  
  </v-container>
  
</template>

<script>
import ItemInfo from './ItemInfo.vue'
export default {
    name: "ItemList",
    components:{ItemInfo},
    props: {
      items: Array,
    },
    data: function () {
    return {
      item: {
              'title' : "title mesessage",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },
      test: [1,2,3,4,5]
    };
  },

}
</script>