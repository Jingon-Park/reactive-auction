<template>
  <v-sheet
    color="white"
    elevation="1"
    height="250"
    outlined
    rounded
    shaped
    width="200"
  >
    <div class="box">
      <v-img :src="item.titleImg" width="150px" height="150px" />
    </div>
    <div class="box">
        titlekhjsdfhsdfdlksjfsdifjsd
        fewlfjweifejwifwe
        fewlfejwlfwej
    </div>
    <div class="box">
        {{item.bidPrice}} 원
    </div>
    
  </v-sheet>

</template>

<script>
export default {
  name: "ItemInfo",
  props: {
    item: Object,
  },
};
</script>

<style scoped>
.box {
    border: 1px solid gray;
}
</style>
