<script setup lang="ts">
import { ref } from 'vue';
import { defineAsyncComponent } from 'vue';
import { LiveCircularProgress } from '@/components';
import { useEventSource } from '@vueuse/core';
const ThreadChart = defineAsyncComponent(() => import('@/views/ThreadChart.vue'));
const value = ref<number>(0);
const innerLoad = ref<boolean>(true);

const { status, data, error, close } = useEventSource('/api/cpu/load', [''], {
  withCredentials: true
});
console.log(data);
const eventSource = new EventSource('/api/cpu/load');
eventSource.onopen = () => {
  innerLoad.value = false;
};
eventSource.onmessage = (msg) => {
  const message = JSON.parse(msg.data);
  value.value = parseFloat(message.load);
};
</script>

<template>
  <q-card>
    <div class="row">
      <div class="col">
        <LiveCircularProgress :is-loading="innerLoad" :value="value" />
      </div>
      <div class="col">.col</div>
      <div class="col">.col</div>
      <div class="col">.col</div>
      <div class="col">.col</div>
    </div>
  </q-card>
  <ThreadChart style="width: 400px; height: 400px" />
  <div class="row">
    <div class="col"></div>
    <div class="col">.col</div>
  </div>
</template>
<route lang="json">
{
  "meta": {
    "requiresAuth": false
  }
}
</route>
