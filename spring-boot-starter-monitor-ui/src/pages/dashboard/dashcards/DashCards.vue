<script setup lang="ts">
import {onMounted, ref} from "vue";
import {hardware} from "src/api/system";
import {Hardware} from "src/types/Hardware";

const hardwareRef = ref<Hardware | null>(null)
const loading = ref<boolean>(true)
const thumbStyle = {
  right: '4px',
  borderRadius: '5px',
  backgroundColor: '#027be3',
  width: '5px',
  opacity: 0.75
};

const barStyle = {
  right: '2px',
  borderRadius: '9px',
  backgroundColor: '#027be3',
  width: '9px',
  opacity: 0.2
}
onMounted(() => {
  hardware().then(r => {
    console.log(r.data)
    hardwareRef.value = r.data
    console.log(hardwareRef.value.computerSystem)
    loading.value = false
  })
});
</script>

<template>
  <div class="q-pa-md">
    <q-scroll-area style="max-width: 100vw;height: 60vh" :thumb-style="thumbStyle" :horizontal-bar-style="barStyle">
      <div class="row no-wrap">
        <div class="col-6 q-pa-sm">
          <q-card class="my-card" flat bordered>
            <q-item>
              <q-item-section avatar>
                <transition-group
                  appear
                  enter-active-class="animated fadeIn"
                  leave-active-class="animated fadeOut"
                >
                  <q-avatar v-if="!loading" icon="computer"/>
                  <q-skeleton animation="wave" v-if="loading" type="QAvatar"/>
                </transition-group>
              </q-item-section>
              <q-item-section>
                <q-item-label>操作系统</q-item-label>
                <q-item-label caption>
                  硬件uuid:{{ hardwareRef?.computerSystem.hardwareUUID }}
                </q-item-label>
                <q-item-label caption>
                  制造商:{{ hardwareRef?.computerSystem.manufacturer }}
                </q-item-label>
                <q-item-label caption>
                  编号:{{ hardwareRef?.computerSystem.serialNumber }}
                </q-item-label>
                <q-item-label caption>
                  模型:{{ hardwareRef?.computerSystem.model }}
                </q-item-label>
              </q-item-section>
            </q-item>
            <q-separator/>
            <q-card-section horizontal>
              <q-card-section>
                固件
                <q-item-label class="text-white" caption>
                  版本:{{ hardwareRef?.computerSystem.firmware.version }}
                </q-item-label>
              </q-card-section>

              <q-separator vertical/>

              <q-card-section class="col-4">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              </q-card-section>
            </q-card-section>
          </q-card>
        </div>
        <div class="col-6 q-pa-sm">
          <q-card class="my-card" flat bordered>
            <q-card-section horizontal>
              <q-card-section class="q-pt-xs">
                <div class="text-overline">Overline</div>
                <div class="text-h5 q-mt-sm q-mb-xs">Title</div>
                <div class="text-caption text-grey">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua.
                </div>
              </q-card-section>

              <q-card-section class="col-5 flex flex-center">
                <q-img
                  class="rounded-borders"
                  src="https://cdn.quasar.dev/img/parallax2.jpg"
                />
              </q-card-section>
            </q-card-section>

            <q-separator/>

            <q-card-actions>
              <q-btn flat round icon="event"/>
              <q-btn flat>
                7:30PM
              </q-btn>
              <q-btn flat color="primary">
                Reserve
              </q-btn>
            </q-card-actions>
          </q-card>
        </div>
        <div class="col-6 q-pa-sm">
          <q-card class="my-card" flat bordered>
            <q-card-section horizontal>
              <q-card-section class="q-pt-xs">
                <div class="text-overline">Overline</div>
                <div class="text-h5 q-mt-sm q-mb-xs">Title</div>
                <div class="text-caption text-grey">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua.
                </div>
              </q-card-section>

              <q-card-section class="col-5 flex flex-center">
                <q-img
                  class="rounded-borders"
                  src="https://cdn.quasar.dev/img/parallax2.jpg"
                />
              </q-card-section>
            </q-card-section>

            <q-separator/>

            <q-card-actions>
              <q-btn flat round icon="event"/>
              <q-btn flat>
                7:30PM
              </q-btn>
              <q-btn flat color="primary">
                Reserve
              </q-btn>
            </q-card-actions>
          </q-card>
        </div>
      </div>
    </q-scroll-area>
  </div>
</template>
