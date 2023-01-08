<template>
  <v-container fillhiegh fluid style="overflow-y: scroll;">
    <v-row>
      <v-img src="@/assets/auctionLogo.png" width="50px" height="50px"></v-img>
    </v-row>
    <!-- item list를 보여주기 위한 layout -->
    <v-row>
      <ItemList v-bind:items="items" ></ItemList>
    </v-row>
  </v-container>
  
</template>

<script>
import ItemList from "../../components/ItemList.vue";
import axios from 'axios'
export default {
  name: "App",
  components: {
    ItemList,
  },
  data(){
    return {
      items : [{
              'title' : "1 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "2 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },{
              'title' : "3 image",
              'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            }]
    }
  },

  methods: {
    searchItem() {
    },
  },
};

window.onload = function() {
  console.log(axios.get(`/items`));
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
