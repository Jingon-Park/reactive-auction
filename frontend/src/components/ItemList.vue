<template>
    <div>test component</div>
    <ItemInfo v-bind:item='item'></ItemInfo>
    <div>
      {{items}}
    </div>
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
      item: {'titleImg' : 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumb2.gettyimageskorea.com%2Fimage_preview%2F700%2F202201%2FFKF%2F1345137937.jpg&type=sc960_832',
              'bidPrice' : 10000
            },
    };
  },

}
</script>