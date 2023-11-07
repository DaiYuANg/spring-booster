import {quasar} from '@quasar/vite-plugin';
import vue from '@vitejs/plugin-vue';
import {defineConfig} from 'vite';
import dtsPlugin from 'vite-plugin-dts';
import vueJsx from '@vitejs/plugin-vue-jsx'

export default defineConfig({
    plugins: [vue(), dtsPlugin(), quasar({}), vueJsx({}),],
    build: {
        sourcemap: true,
        lib: {
            entry: './src/index.ts',
            name: 'toolkit-vue-components',
            fileName: 'toolkit-vue-components',
        },
    },
});
