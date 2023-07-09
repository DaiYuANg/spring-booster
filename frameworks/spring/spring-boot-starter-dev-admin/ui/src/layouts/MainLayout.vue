<template>
  <q-layout view="lHh lpR fFf">
    <q-ajax-bar />
    <MainLayoutHeader
      @setLeftDrawerOpen="setLeftDrawerOpen"
      @setRightDrawerOpen="setRightDrawerOpen"
    />

    <MainLayoutSidebar
      @hover="hover"
      :model-value="leftDrawerOpen"
      @update:model-value="leftDrawerOpen = $event"
    />
    <q-drawer v-model="rightDrawerOpen" side="right" bordered>
      <!-- drawer content -->
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>


    <MainLayoutFooter />

      <PieEcharts id-name="demo"/>
  </q-layout>
</template>

<script setup lang="ts">
import { api } from 'boot/axios';
import { ref } from 'vue';
import { QDrawer } from 'quasar';
import MainLayoutHeader from 'layouts/MainLayoutHeader.vue';
import MainLayoutFooter from 'layouts/MainLayoutFooter.vue';
import MainLayoutSidebar from 'layouts/MainLayoutSidebar.vue';
import PieEcharts from "components/echarts/PieEcharts.vue";

api.get('/test').then((r) => {
  console.log(r);
});

const leftDrawerOpen = ref(false);

const rightDrawerOpen = ref(false);
const leftDrawer = ref<QDrawer | null>(null);

const setLeftDrawerOpen = () => {
  leftDrawerOpen.value = !leftDrawerOpen.value;
};
const setRightDrawerOpen = () => {
  rightDrawerOpen.value = !rightDrawerOpen.value;
};

const hover = () => {
  console.log(123);
  // if (leftDrawer.value !== null){
  // }
};
</script>
