import { fileURLToPath, URL } from 'node:url'

import {defineConfig, PluginOption} from 'vite'
import vue from '@vitejs/plugin-vue'
import {quasar, transformAssetUrls} from "@quasar/vite-plugin";
import {VitePWA} from "vite-plugin-pwa";
import {visualizer} from "rollup-plugin-visualizer";
import TurboConsole from 'unplugin-turbo-console/vite'
import * as path from "node:path";
import compression from "vite-plugin-compression2";
import zipPack from "vite-plugin-zip-pack";
// https://vitejs.dev/config/
const baseOutDir = path.join("./","build")
const dist = path.join(baseOutDir,"dist")
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
      gzipSize:true
    }) as PluginOption,
    TurboConsole({
    }),
    compression({
      algorithm:'gzip'
    }),
    zipPack({
      inDir:dist,
      outDir:baseOutDir
    })
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server:{
    proxy:{
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    }
  },
  build:{
    outDir:dist,
    cssCodeSplit:true,
    sourcemap:false,
    minify: 'terser',
    terserOptions: {
      compress: {
        drop_console: true,
        drop_debugger: true
      }
    }
  }
})
