import { quasar } from '@quasar/vite-plugin';
import vue from '@vitejs/plugin-vue';
import { defineConfig } from 'vite';
import dtsPlugin from 'vite-plugin-dts';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), dtsPlugin(), quasar({})],
  build: {
    sourcemap: true,
    lib: {
      entry: './src/index.ts',
      name: 'toolkit-vue-components',
      fileName: 'toolkit-vue-components',
    },
  },
});
