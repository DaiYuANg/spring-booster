<template>
  <q-chip style="cursor: pointer" size="md" icon="alarm">{{ current }}</q-chip>
</template>

<script setup lang="ts">
import { onBeforeUnmount, ref } from 'vue'
import { date, QChip } from 'quasar'

const currentDate = (): string => {
  return date.formatDate(Date.now(), 'YYYY-MM-DD HH:mm:ss')
}

let current = ref<string>(currentDate())

const timeOut = setInterval(() => {
  current.value = currentDate()
}, 1000)

onBeforeUnmount(() => {
  clearInterval(timeOut)
})
</script>
