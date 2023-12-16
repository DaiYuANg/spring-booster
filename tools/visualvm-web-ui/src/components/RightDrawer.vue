<script setup lang="ts">
defineProps<{
  rightDrawerOpen:boolean
}>()
</script>
<template>
  <q-drawer v-bind:model-value="rightDrawerOpen" side="right" bordered>
    <!-- drawer content -->
  </q-drawer>
</template>
