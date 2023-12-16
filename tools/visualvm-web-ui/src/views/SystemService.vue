<script setup lang="ts">
import { useQuery } from '@tanstack/vue-query';
import { computed, ref } from 'vue';
import { isEmpty } from 'lodash';
import { queryProcessInfo } from '@/api/process';
import type { Process, Service } from '@/types';
import {ProcessService, SystemInfoService} from '@/services';
import { useContainer } from '@/hooks/useContainer';
const systemInfoService = useContainer<SystemInfoService>(SystemInfoService);
const processService = useContainer<ProcessService>(ProcessService)
const processId = ref<number | undefined>(undefined);
const isEnabled = computed(() => !!processId.value);
const processInfo = ref<Process | undefined>(undefined);
const open = ref<boolean>(false);
const pagination = { rowsPerPage: 0 };
const filter = ref<string>('');

useQuery({
  queryKey: ['process'],
  queryFn: async () => {
    return processService?.queryProcessInfo(processId.value!);
  },
  select: (data) => {
    processInfo.value = data
    open.value = true;
  },
  enabled: isEnabled
});

type tableService = {
  index: number;
} & Service;

const { data: systemService } = useQuery({
  queryKey: ['service'],
  queryFn: async () => {
    return await systemInfoService!.querySystemService();
  },
  select(data) {
    return data.map((v, i) => {
      const d: tableService = {
        ...v,
        index: i
      };
      return d;
    });
  }
});

const columns = [
  {
    name: 'index',
    label: '#',
    field: 'index',
    sortable: true
  },
  {
    name: 'name',
    required: true,
    label: 'Name',
    align: 'left',
    field: (row: any) => row.name,
    format: (val: any) => `${val}`,
    sortable: true
  },
  { name: 'processID', align: 'center', label: 'processID', field: 'processID', sortable: true },
  { name: 'state', align: 'center', label: 'state', field: 'state', sortable: true }
];

const filterMethod = (rows: readonly any[]): Array<any> => {
  if (isEmpty(filter.value)) {
    return [];
  }
  return rows.filter((value: Service) => {
    return (
      value.name.includes(filter.value) ||
      value.state.includes(filter.value) ||
      value.processID.toString().includes(filter.value)
    );
  });
};
</script>
<template>
  <q-table
    class="my-sticky-virtscroll-table"
    style="height: 800px"
    flat
    bordered
    :filter="filter"
    :filter-method="filterMethod"
    title="System Services"
    :rows="systemService as any"
    :columns="columns as any"
    row-key="index"
    virtual-scroll
    :virtual-scroll-item-size="48"
    :virtual-scroll-sticky-size-start="48"
    :pagination="pagination"
    :rows-per-page-options="[0]"
    @row-click="(event: Event, row: tableService) => (processId = row.processID)"
  >
    <template v-slot:top-right>
      <q-input borderless dense debounce="300" v-model="filter" placeholder="Search">
        <template v-slot:append>
          <q-icon name="search" />
        </template>
      </q-input>
    </template>

    <template v-slot:no-data="{ icon, message }">
      <div class="full-width row flex-center text-accent q-gutter-sm">
        <q-icon size="2em" name="sentiment_dissatisfied" />
        <span> Well this is sad... {{ message }} </span>
        <q-icon size="2em" :name="filter ? 'filter_b_and_w' : icon" />
      </div>
    </template>
  </q-table>
  <q-dialog v-model="open">
    <q-card style="width: 700px; max-width: 80vw">
      <q-card-section>
        <div class="text-h5">{{ processInfo?.name }}</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        <div class="row">
          <div class="col">参数</div>
          <div class="col">
            <div v-for="argument in processInfo?.arguments" v-bind:key="argument">
              {{ argument }}
            </div>
          </div>
        </div>
      </q-card-section>

      <q-card-actions align="right" class="text-primary">
        <q-btn flat label="Open another dialog" />
        <q-btn
          flat
          label="Close"
          v-close-popup
          @click="
            () => {
              open = false;
              processId = undefined;
            }
          "
        />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>
