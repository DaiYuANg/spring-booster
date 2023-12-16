<script setup lang="ts">
import LiveDate from '@/components/LiveDate.vue';
defineProps<{
  toggleLeftDrawer: () => void;
  toggleRightDrawer: () => void;
}>();
</script>
<template>
  <q-header elevated class="bg-primary text-white">
    <q-toolbar>
      <q-btn dense flat round icon="menu" @click="toggleLeftDrawer" />
      <q-toolbar-title> Title </q-toolbar-title>
      <LiveDate />
      <q-btn dense flat round icon="menu" @click="toggleRightDrawer" />
    </q-toolbar>
  </q-header>
</template>
