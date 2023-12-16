<script setup lang="ts">
import 'xterm/css/xterm.css';
import { Terminal } from 'xterm';
import {onMounted} from "vue";
import { FitAddon } from 'xterm-addon-fit';
import { WebglAddon } from 'xterm-addon-webgl';
import { CanvasAddon } from 'xterm-addon-canvas'
const terminal = new Terminal()
terminal.loadAddon(new CanvasAddon());
terminal.loadAddon(new FitAddon())
terminal.loadAddon(new WebglAddon());
onMounted(()=>{
  terminal.open(document.getElementById('terminal')!);
})
</script>

<template>
  <div id="terminal"></div>
</template>
