<template>
  <q-drawer :width="200"
            :breakpoint="400" ref="leftDrawer"
            @mouseover="$emit('hover')"
            show-if-above
            :model-value="leftDrawerOpen"
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
</template>

<script lang="ts" setup>
  defineProps({
    leftDrawerOpen: Boolean
  })
</script>

