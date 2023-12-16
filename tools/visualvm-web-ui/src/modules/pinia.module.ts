import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
import { createPinia } from 'pinia';
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate';
import { injectable, registry, singleton } from 'tsyringe';
import type { App } from 'vue';

@injectable()
@singleton()
@registry([{ token: AppModuleToken, useToken: PiniaModule }])
class PiniaModule implements AppModule {
  private readonly piniaInstance = createPinia();
  setup(app: App): void {
    this.piniaInstance.use(piniaPluginPersistedstate);
    app.use(this.piniaInstance);
  }
}

export { PiniaModule };
