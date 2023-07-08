<template>
  <q-page padding class="q-pa-md">
    System Info
    <div class="row">
      <div class="col q-pa-sm">
        <div id="chart" :style="{  height: '300px' }"> </div>
      </div>
    </div>
  </q-page>
</template>

<script setup lang="ts">
import {onMounted, onUnmounted} from "vue";
import * as echarts from "echarts";
import axios from "axios";

const ws = new WebSocket("ws://localhost:8080/dev/admin/system/info")
ws.onopen = function (){
  setInterval(()=>{
    ws.send("")
  },1000)
}

onMounted(() => {
  let chart = echarts.init(document.getElementById("chart") as HTMLElement
    , "dark");
  // 把配置和数据放这里
  chart.setOption({
    xAxis: {
      type: "category",
      data: [
        "一月",
        "二月",
        "三月",
        "四月",
        "五月",
        "六月",
        "七月",
        "八月",
        "九月",
        "十月",
        "十一月",
        "十二月"
      ]
    },
    tooltip: {
      trigger: "axis"
    },
    yAxis: {
      type: "value"
    },
    series: [
      {
        data: [
          820,
          932,
          901,
          934,
          1290,
          1330,
          1320,
          801,
          102,
          230,
          4321,
          4129
        ],
        type: "line",
        smooth: true
      }
    ]
  });
  window.onresize = function() {
    //自适应大小
    chart.resize();
  };
});

onUnmounted(() => {
  echarts.dispose;
});

</script>
