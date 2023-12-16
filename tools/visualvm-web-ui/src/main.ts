import {createApp} from 'vue'
import {createPinia} from 'pinia'
import '@quasar/extras/material-icons/material-icons.css'
import '@quasar/extras/fontawesome-v6/fontawesome-v6.css'
import "@fontsource/jetbrains-mono"; // Defaults to weight 400
import "@fontsource/jetbrains-mono/400.css"; // Specify weight
import "@fontsource/jetbrains-mono/400-italic.css"; // Specify weight and style
import 'quasar/src/css/index.sass'
import '@quasar/extras/mdi-v7/mdi-v7.css'
import "@quasar/extras/animate/fadeIn.css"
import '@quasar/extras/animate/fadeOut.css'
import App from './App.vue'
import router from './router'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import {
    AppFullscreen,
    AppVisibility,
    Dialog,
    Loading,
    LoadingBar,
    LocalStorage,
    Notify,
    Quasar,
    SessionStorage
} from "quasar";
import {VueQueryPlugin} from "@tanstack/vue-query";

const app = createApp(App)
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate)
app.use(pinia)
app.use(router)
app.use(Quasar, {
    config: {
        dark: "auto"
    },
    plugins: {
        Loading,
        LoadingBar,
        LocalStorage,
        SessionStorage,
        Notify,
        Dialog,
        AppFullscreen,
        AppVisibility
    },
})
app.use(VueQueryPlugin)
app.mount('#app')
