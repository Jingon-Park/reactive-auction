<template>
  <v-col>
    <v-card class="mx-auto" max-width="344" min-width="344">
      <v-img :src="item.titleImg" height="200px"></v-img>

      <v-card-title style="text-align: left">
        {{ item.title }}
      </v-card-title>

      <v-card-text style="text-align: left; height: 50px">
        {{ item.descript }}
        ffewfew fwefwefwe fwefewfwefwefffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewfffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewfffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewfffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewfffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewfffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewfffewfew fwefwefwe fwefewfwefwef
        wefwfewfewfwe fewfewfewfewfw fwfewfwefewf
      </v-card-text>
    </v-card>
  </v-col>
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
