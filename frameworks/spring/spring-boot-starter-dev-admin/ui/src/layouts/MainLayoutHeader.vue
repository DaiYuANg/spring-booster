<template>
  <q-header reveal class="bg-primary text-white" height-hint="98">
    <q-toolbar>
      <q-btn dense flat round icon="menu" @click="$emit('setLeftDrawerOpen')" />
      <q-toolbar-title>
        <q-avatar>
          <img
            src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg"
            alt=""
          />
        </q-avatar>
        Dev Admin
      </q-toolbar-title>
      <q-space />
      <LiveDate />
      <q-btn
        dense
        flat
        round
        icon="menu"
        @click="$emit('setRightDrawerOpen')"
      />
    </q-toolbar>
  </q-header>
</template>

<script setup lang="ts">
import LiveDate from 'components/LiveDate.vue';
</script>
