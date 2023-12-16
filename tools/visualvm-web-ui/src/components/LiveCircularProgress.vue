<script setup lang="ts">
type liveCircularProgressProp = {
  value: number;
  isLoading: boolean;
};

defineProps<liveCircularProgressProp>();
</script>

<template>
  <q-circular-progress
    show-value
    class="text-light-blue q-ma-md"
    v-bind:value="value"
    font-size="18px"
    size="150px"
    :thickness="0.02"
    color="light-blue"
  >
    {{ value }}
    <q-icon name="mdi-chip" size="lg" />
    <q-inner-loading :showing="isLoading">
      <q-spinner-gears size="50px" color="primary" />
    </q-inner-loading>
  </q-circular-progress>
</template>
