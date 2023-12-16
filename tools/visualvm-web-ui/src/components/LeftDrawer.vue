<script setup lang="ts">
import {fasEarthAmericas} from "@quasar/extras/fontawesome-v6";
import {fasFlask} from "@quasar/extras/fontawesome-v5";

defineProps<{
  leftDrawerOpen: boolean
}>()
const links1 = [
  {icon: 'web', text: 'Top stories'},
  {icon: 'person', text: 'For you'},
  {icon: 'star_border', text: 'Favourites'},
  {icon: 'search', text: 'Saved searches'}
]
const links2 = [
  {icon: 'flag', text: 'Canada'},
  {icon: fasEarthAmericas, text: 'World'},
  {icon: 'place', text: 'Local'},
  {icon: 'domain', text: 'Business'},
  {icon: 'memory', text: 'Technology'},
  {icon: 'local_movies', text: 'Entertainment'},
  {icon: 'directions_bike', text: 'Sports'},
  {icon: fasFlask, text: 'Science'},
  {icon: 'fitness_center', text: 'Health '}
]
const links3 = [
  {icon: '', text: 'Language & region'},
  {icon: '', text: 'Settings'},
  {icon: 'open_in_new', text: 'Get the Android app'},
  {icon: 'open_in_new', text: 'Get the iOS app'},
  {icon: '', text: 'Send feedback'},
  {icon: 'open_in_new', text: 'Help'}
];
</script>

<template>
  <q-drawer show-if-above v-bind:model-value="leftDrawerOpen" side="left" bordered>
    <q-scroll-area class="fit">
      <q-list padding class="text-grey-8">
        <q-item class="GNL__drawer-item" v-ripple v-for="link in links1" :key="link.text" clickable>
          <q-item-section avatar>
            <q-icon :name="link.icon"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>{{ link.text }}</q-item-label>
          </q-item-section>
        </q-item>
        <q-item class="GNL__drawer-item" to="/" exact v-ripple clickable>
          <q-item-section avatar>
            <q-icon name="dashboard"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Dashboard</q-item-label>
          </q-item-section>
        </q-item>
        <q-item class="GNL__drawer-item" to="/system/service" exact v-ripple clickable>
          <q-item-section avatar>
            <q-icon name="service"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Service</q-item-label>
          </q-item-section>
        </q-item>
        <q-separator inset class="q-my-sm"/>

        <q-item class="GNL__drawer-item" v-ripple v-for="link in links2" :key="link.text" clickable>
          <q-item-section avatar>
            <q-icon :name="link.icon"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>{{ link.text }}</q-item-label>
          </q-item-section>
        </q-item>

        <q-separator inset class="q-my-sm"/>

        <q-item class="GNL__drawer-item" v-ripple v-for="link in links3" :key="link.text" clickable>
          <q-item-section>
            <q-item-label>{{ link.text }}
              <q-icon v-if="link.icon" :name="link.icon"/>
            </q-item-label>
          </q-item-section>
        </q-item>
      </q-list>
    </q-scroll-area>
  </q-drawer>
</template>

