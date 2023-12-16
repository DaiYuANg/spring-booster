<template>
  <q-layout view="hHh lpR fFf">

    <LayoutHeader :toggle-right-drawer="toggleRightDrawer" :toggle-left-drawer="toggleLeftDrawer"/>

    <LeftDrawer :left-drawer-open="leftDrawerOpen"/>

    <RightDrawer :right-drawer-open="rightDrawerOpen"/>

    <q-page-container>
      <router-view v-slot="{ Component }">
        <transition name="fade">
          <component :is="Component"/>
        </transition>
      </router-view>
    </q-page-container>

    <LayoutFooter/>
  </q-layout>
</template>

<script setup lang="ts">
import {ref} from 'vue'
import {fasFlask} from "@quasar/extras/fontawesome-v5";
import {fasEarthAmericas} from "@quasar/extras/fontawesome-v6";
import LiveDate from "@/components/LiveDate.vue";
import LeftDrawer from "@/components/LeftDrawer.vue";
import RightDrawer from "@/components/RightDrawer.vue";
import LayoutHeader from "@/components/LayoutHeader.vue";
import LayoutFooter from "@/components/LayoutFooter.vue";

const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)
const toggleLeftDrawer = () => {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
const toggleRightDrawer = () => {
  rightDrawerOpen.value = !rightDrawerOpen.value
}
</script>