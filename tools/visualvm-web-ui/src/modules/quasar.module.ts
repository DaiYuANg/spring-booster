import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
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
} from 'quasar';
import type { QuasarUIConfiguration } from 'quasar/dist/types/config';
import type { QuasarPlugins } from 'quasar/dist/types/plugin';
import { injectable, registry, singleton } from 'tsyringe';
import type { App } from 'vue';

@injectable()
@singleton()
@registry([{ token: AppModuleToken, useToken: QuasarModule }])
class QuasarModule implements AppModule {
  private readonly plugins: QuasarPlugins = {
    Loading,
    LoadingBar,
    LocalStorage,
    SessionStorage,
    Notify,
    Dialog,
    AppFullscreen,
    AppVisibility
  };

  private config: QuasarUIConfiguration = {
    dark: 'auto'
  };

  setup(app: App): void {
    app.use(Quasar, {
      config: this.config,
      plugins: this.plugins
    });
  }
}

export { QuasarModule };
