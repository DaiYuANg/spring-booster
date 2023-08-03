<template>
  <q-page padding class="q-pa-md">
    <div class="row">
      <div class="col q-pa-sm">
        <div id="chart" :style="{ height: '300px' }"></div>
      </div>
    </div>
  </q-page>
</template>

<script setup lang="ts">
import {onMounted, onUnmounted, ref} from 'vue';
import * as echarts from 'echarts';
import {memory, threads} from 'src/api/system';

type poll = {
  pollTimer: NodeJS.Timeout | undefined,
  data: any | undefined
}

const memoryPoll = ref<poll>({
  pollTimer: undefined,
  data: undefined
})

onMounted(() => {
  memory().then((r) => {
    console.log(r);
  });
  // memoryPoll.value.pollTimer = setInterval(() => {
  //   memory().then((r) => {
  //     console.log(r);
  //   });
  // }, 1000)
  // setInterval(() => {
  //   // threads().then(r => {
  //   //   console.log(r)
  //   // })
  // }, 500)
  // let chart = echarts.init(
  //   document.getElementById('chart') as HTMLElement,
  //   'dark'
  // );
  // // 把配置和数据放这里
  // chart.setOption({
  //   xAxis: {
  //     type: 'category',
  //     data: [
  //       '一月',
  //       '二月',
  //       '三月',
  //       '四月',
  //       '五月',
  //       '六月',
  //       '七月',
  //       '八月',
  //       '九月',
  //       '十月',
  //       '十一月',
  //       '十二月',
  //     ],
  //   },
  //   tooltip: {
  //     trigger: 'axis',
  //   },
  //   yAxis: {
  //     type: 'value',
  //   },
  //   series: [
  //     {
  //       data: [820, 932, 901, 934, 1290, 1330, 1320, 801, 102, 230, 4321, 4129],
  //       type: 'line',
  //       smooth: true,
  //     },
  //   ],
  // });
  // window.onresize = function () {
  //   //自适应大小
  //   chart.resize();
  // };
});

onUnmounted(() => {
  echarts.dispose;
});
</script>
