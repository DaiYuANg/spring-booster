<template>
  <q-layout view="hHh lpR fFf">
    <LayoutHeader :toggle-right-drawer="toggleRightDrawer" :toggle-left-drawer="toggleLeftDrawer" />
    <LeftDrawer :left-drawer-open="leftDrawerOpen" />
    <RightDrawer :right-drawer-open="rightDrawerOpen" />
    <q-page-container>
      <router-view v-slot="{ Component, route }">
        <q-page>
          <transition name="fade">
            <component :is="Component" :key="route" />
          </transition>
        </q-page>
      </router-view>
    </q-page-container>
    <LayoutFooter />
  </q-layout>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import LeftDrawer from '@/layout/LeftDrawer.vue';
import RightDrawer from '@/layout/RightDrawer.vue';
import LayoutHeader from '@/layout/LayoutHeader.vue';
import LayoutFooter from '@/layout/LayoutFooter.vue';

const leftDrawerOpen = ref(false);
const rightDrawerOpen = ref(false);
const toggleLeftDrawer =  async () => {
  leftDrawerOpen.value = !leftDrawerOpen.value;
};
const toggleRightDrawer = async () => {
  rightDrawerOpen.value = !rightDrawerOpen.value;
};
</script>
