<script setup lang="ts">
import {onMounted} from "vue";

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
   * fullscreen
   */
  fullscreen?: boolean,
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
onMounted(()=>{
  console.log(123)
})
</script>

<template>
  <div class="flex justify-center items-center fullscreen">
    Central Layout
  </div>
</template>
