<template>
  <div :id="props.idName"></div>
</template>

<script setup lang="ts">
/**
 * @idName  Html id name
 * @title Title property
 */
import echarts, { ECOption } from 'boot/echarts';
import { onMounted } from 'vue';

const props = defineProps({
  idName: {
    type: String,
    required: true,
  },
  option: {
    type: Object,
  },
});

//The Echarts property is assigned a value
const initEcharts = () => {
  let _charDom = document.getElementById(props.idName) as HTMLElement;
  let _myChar = echarts.init(_charDom);
  if (props.option === undefined) {
    return;
  }
  _myChar.setOption(props.option as ECOption);
  window.onresize = function () {
    //自适应大小
    _myChar.resize();
  };
};

onMounted(() => {
  //initEcharts call
  initEcharts();
});
</script>

<style scoped></style>
