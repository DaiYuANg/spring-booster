<template>
  <q-layout view="lHh lpR fFf">
    <q-ajax-bar/>
    <q-header reveal class="bg-primary text-white" height-hint="98">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="leftDrawerOpen = !leftDrawerOpen"/>

        <q-toolbar-title>
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg" alt="">
          </q-avatar>
          Dev Admin
        </q-toolbar-title>

        <q-btn dense flat round icon="menu" @click="rightDrawerOpen = !rightDrawerOpen"/>
      </q-toolbar>

      <q-tabs align="left">
        <q-route-tab to="/page1" label="Page One"/>
        <q-route-tab to="/page2" label="Page Two"/>
        <q-route-tab to="/page3" label="Page Three"/>
      </q-tabs>
    </q-header>

    <q-drawer :width="200"
      :breakpoint="400" ref="leftDrawer" @mouseover="hover" show-if-above v-model="leftDrawerOpen"
      side="left" bordered>
      <q-scroll-area style="height: calc(100% - 150px);">
        <q-list padding>
          <q-item active clickable v-ripple>
            <q-item-section avatar>
              <q-icon name="dashboard"/>
            </q-item-section>

            <q-item-section>
              Dashboard
            </q-item-section>
          </q-item>

          <q-item clickable v-ripple>
            <q-item-section avatar>
              <q-icon name="star"/>
            </q-item-section>

            <q-item-section>
              Star
            </q-item-section>
          </q-item>

          <q-item clickable v-ripple>
            <q-item-section avatar>
              <q-icon name="send"/>
            </q-item-section>

            <q-item-section>
              Send
            </q-item-section>
          </q-item>

          <q-item clickable v-ripple>
            <q-item-section avatar>
              <q-icon name="drafts"/>
            </q-item-section>

            <q-item-section>
              Drafts
            </q-item-section>
          </q-item>
        </q-list>
      </q-scroll-area>
    </q-drawer>

    <q-drawer v-model="rightDrawerOpen" side="right" bordered>
      <!-- drawer content -->
    </q-drawer>

    <q-page-container>
      <router-view/>
    </q-page-container>

    <q-footer reveal elevated class="bg-grey-8 text-white">
      <q-toolbar>
        <q-toolbar-title>
          <q-btn icon="menu"></q-btn>
          <q-avatar>
          </q-avatar>
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script setup lang="ts">
import {api} from "boot/axios";
import {ref} from "vue";
import {QDrawer} from "quasar";

api.get("/test").then(r => {
  console.log(r)
})
const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)
const leftDrawer = ref<QDrawer | null>(null)


const hover = () => {
  console.log(123)
  // if (leftDrawer.value !== null){
  // }
}
</script>
