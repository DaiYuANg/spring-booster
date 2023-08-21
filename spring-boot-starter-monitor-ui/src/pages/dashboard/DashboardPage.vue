<template>
  <q-page padding class="q-pa-md">
    <DashCards />
  </q-page>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import DashCards from "pages/dashboard/dashcards/DashCards.vue";
import {operationSystem} from "src/api/system";

type poll = {
  pollTimer: NodeJS.Timeout | undefined,
  data: any | undefined
}

const memoryPoll = ref<poll>({
  pollTimer: undefined,
  data: undefined
})

onMounted(()=>{
  operationSystem().then(r=>{
    console.log(r)
  })
})
</script>
