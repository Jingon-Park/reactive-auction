<template>
  <v-img src="@/assets/auctionLogo.png" width="50px"></v-img>

  <h2>main test</h2>
  <ItemList v-bind:items="items" ></ItemList>
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
      items : []
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
