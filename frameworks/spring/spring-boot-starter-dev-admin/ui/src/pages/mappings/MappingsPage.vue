<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue';
import { mappings } from 'src/api/actuator';

let mappingsList: { dispatcherServlets: any } | undefined = undefined;

const data = reactive({
  dispatcherServlet: undefined,
});

onMounted(() => {
  mappings().then((r) => {
    data.dispatcherServlet =
      r.contexts.application.mappings.dispatcherServlets.dispatcherServlet;
    console.log(data.dispatcherServlet);
  });
});

const columns = ref([
  {
    name: 'handler',
    required: true,
    label: 'handler',
    align: 'left',
    field: (row) => row.handler,
    format: (val) => `${val}`,
    sortable: true,
  },
  {
    name: 'predicate',
    required: true,
    label: 'predicate',
    align: 'left',
    field: (row) => row.predicate,
    format: (val) => `${val}`,
    sortable: true,
  },
]);
const initialPagination = {
  sortBy: 'desc',
  descending: false,
  page: 1,
  rowsPerPage: 10,
};
</script>

<template>
  <q-table
    flat
    title="DispatcherServlet"
    :rows="data.dispatcherServlet"
    :columns="columns"
    row-key="index"
    :pagination="initialPagination"
  />
</template>

<style scoped></style>
