<script setup lang="ts">

import {ref} from "vue";

const value = ref<number>(0)

const eventSource = new EventSource("/api/cpu/load");
eventSource.onmessage = (msg) => {
  const message = JSON.parse(msg.data)
  value.value = parseFloat(message.load)
}
</script>

<template>
  <q-card>
    <div class="row">
      <div class="col">
        <q-circular-progress
            show-value
            class="text-light-blue q-ma-md"
            :value="value"
            font-size="18px"
            size="150px"
            :thickness=".02"
            color="light-blue"
        >
          {{value}}
          <q-icon name="mdi-chip" size="lg"/>
        </q-circular-progress>
      </div>
      <div class="col">
        .col
      </div>
      <div class="col">
        .col
      </div>
      <div class="col">
        .col
      </div>
      <div class="col">
        .col
      </div>
    </div>
  </q-card>
  <div class="row">
    <div class="col">
      .col
    </div>
    <div class="col">
      .col
    </div>
  </div>
</template>
