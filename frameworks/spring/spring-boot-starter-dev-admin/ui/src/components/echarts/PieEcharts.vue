<template>
<div :id="props.idName"></div>
</template>

<script setup lang="ts">
/**
 * @idName  Html id name
 * @title Title property
 */
import echarts from 'boot/echarts';
import { EChartsOption } from 'echarts';
import {onMounted} from "vue";

const props = defineProps({
  idName: {
    type: String,
    required: true,
  },
  title: {
    type: Object,
  },
  tooltip: {
    type: Object,
  },
});


const option:EChartsOption = {};

//Option Object assignment
const setOption = () =>{
  if(props.title !== undefined){
      option.title = props.title;
  }

}

//The Echarts property is assigned a value
const initEcharts = ()=>{
  let _charDom = document.getElementById(props.idName) as HTMLElement;
  let _myChar = echarts.init(_charDom);
  setOption();
  _myChar.setOption(option)
}

onMounted(()=>{
  //initEcharts call
  initEcharts();
})
</script>

<style scoped></style>
