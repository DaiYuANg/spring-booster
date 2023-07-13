<script setup lang="ts">
import {ref} from 'vue';
import dayjs from 'dayjs';

const currentDate = (): string => {
  return dayjs().format('YYYY-MM-DD HH:mm:ss');
};

let date = ref<string>(currentDate());

setInterval(() => {
  date.value = currentDate();
}, 1000);
</script>

<template>
  <q-chip style="cursor: pointer" size="md" icon="alarm">{{ date }}</q-chip>
</template>
