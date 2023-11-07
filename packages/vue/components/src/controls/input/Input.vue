<script setup lang="ts">
import {ref, useAttrs} from "vue";

const props = withDefaults(defineProps<{
  /**
   * The label of the button
   */
  label: string,
  /**
   * primary or secondary button
   */
  primary?: boolean,
  /**
   * size of the button
   */
  size?: 'small' | 'medium' | 'large',
  /**
   * background color of the button
   */
  backgroundColor?: string,

}>(), {primary: false});
console.log(props)
const attrs = useAttrs()
console.log(attrs)
const value = ref()
</script>

<template>
  <q-input v-model="value" autofocus v-bind="$attrs" label="test"></q-input>
</template>
