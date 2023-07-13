<script setup lang="ts">
import {SessionStorage} from 'quasar';

console.log(SessionStorage.getItem('mappings'));
const adjustIframe = () => {
  console.log(123);
};
</script>

<template>
  <iframe
    id="bi_iframe"
    src="http://localhost:8080/swagger-ui.html"
    style="width: 100%; height: 85vh; border: none"
    @load="adjustIframe"
  ></iframe>
</template>

<style scoped></style>
