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
      <LiveDate />
      <q-btn
        dense
        flat
        round
        icon="menu"
        @click="$emit('setRightDrawerOpen')"
      />
    </q-toolbar>

    <q-tabs align="left">
      <q-route-tab to="/page1" label="Page One" />
      <q-route-tab to="/page2" label="Page Two" />
      <q-route-tab to="/page3" label="Page Three" />
    </q-tabs>
  </q-header>
</template>

<script setup lang="ts">
import LiveDate from 'components/LiveDate.vue';
</script>
