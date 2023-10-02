<script setup lang="ts">
import {QTable} from "quasar";
import {defineSlots} from "vue";
import {TablePageProps, TablePageSlots} from "./TablepageTypes.ts";



const props = withDefaults(defineProps<TablePageProps>(), {})
const slots = defineSlots<TablePageSlots>()

</script>

<template>
    <q-table
        title="Treats"
        v-bind="props.tableProp"
        row-key="name"
    />
</template>