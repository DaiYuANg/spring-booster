<template></template>

<script setup lang="ts">
/**
 * @idName  Html id name
 */
import echarts from 'boot/echarts';
import { EChartsOption } from 'echarts';

const props = defineProps({
  idName: {
    type: String,
    required: true,
  },
  title: {
    type: Object,
  },
});

let charDom = document.getElementById(props.idName) as HTMLElement;
let myChar = echarts.init(charDom);
let option: EChartsOption;

option = {};
</script>

<style scoped></style>
