/* prettier-ignore */
import 'reflect-metadata';
/* prettier-ignore */
import '@/modules';
import '@/services';
/*eslint-disable*/
import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
import { containerSymbol } from '@/types/inject';
import '@fontsource/jetbrains-mono'; // Defaults to weight 400
import '@fontsource/jetbrains-mono/400-italic.css'; // Specify weight and style
import '@fontsource/jetbrains-mono/400.css'; // Specify weight
import '@quasar/extras/animate/fadeIn.css';
import '@quasar/extras/animate/fadeOut.css';
import '@quasar/extras/fontawesome-v6/fontawesome-v6.css';
import '@quasar/extras/material-icons/material-icons.css';
import '@quasar/extras/mdi-v7/mdi-v7.css';
import 'quasar/src/css/index.sass';
import { container } from 'tsyringe';
import type { App } from 'vue';
import { createApp } from 'vue';
import MainApp from './App.vue';

const setupAppModules = async (app: App): Promise<App> => {
  if (!container.isRegistered(AppModuleToken)) return app;
  const modules = container.resolveAll<AppModule>(AppModuleToken);
  for (let module of modules) {
    module.setup(app);
  }
  return app;
};

const appRender = (app: App) => {
  app.provide(containerSymbol, container);
  app.mount('#app');
};

(async function () {
  return createApp(MainApp);
})()
  .then(setupAppModules)
  .then(appRender);
