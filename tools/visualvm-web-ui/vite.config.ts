import { fileURLToPath, URL } from 'node:url';

import { quasar, transformAssetUrls } from '@quasar/vite-plugin';
import vue from '@vitejs/plugin-vue';
import * as path from 'node:path';
import { visualizer } from 'rollup-plugin-visualizer';
import TurboConsole from 'unplugin-turbo-console/vite';
import { defineConfig, PluginOption } from 'vite';
import compression from 'vite-plugin-compression2';
import Pages from 'vite-plugin-pages';
import { VitePWA } from 'vite-plugin-pwa';
import Layouts from 'vite-plugin-vue-layouts';
import zipPack from 'vite-plugin-zip-pack';
const baseOutDir = path.join('./', 'build');
const dist = path.join(baseOutDir, 'dist');
export default defineConfig({
  plugins: [
    vue({
      template: { transformAssetUrls }
    }),
    quasar({
      sassVariables: 'src/styles/quasar-variables.sass'
    }),
    VitePWA({ registerType: 'autoUpdate' }),
    visualizer({
      gzipSize: true
    }) as PluginOption,
    TurboConsole({}),
    compression({
      algorithm: 'gzip'
    }),
    zipPack({
      inDir: dist,
      outDir: baseOutDir
    }),
    Pages({
      dirs: 'src/views',
      importMode: 'async'
    }),
    Layouts({
      layoutsDirs: 'src/layout',
      pagesDirs: 'src/views',
      defaultLayout: 'MainLayout'
    })
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
      vue: 'vue/dist/vue.esm-bundler.js'
    }
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  },
  build: {
    outDir: dist,
    cssCodeSplit: true,
    sourcemap: false,
    minify: 'terser',
    terserOptions: {
      compress: {
        drop_console: true,
        drop_debugger: true
      }
    }
  }
});
