import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
import { VueQueryPlugin } from '@tanstack/vue-query';
import { injectable, registry, singleton } from 'tsyringe';
import type { App } from 'vue';

@injectable()
@singleton()
@registry([{ token: AppModuleToken, useToken: VueQueryModule }])
class VueQueryModule implements AppModule {
  setup(app: App): void {
    app.use(VueQueryPlugin);
  }
}

export { VueQueryModule };
