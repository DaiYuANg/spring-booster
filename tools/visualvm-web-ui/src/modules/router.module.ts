import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
import { injectable, registry, singleton } from 'tsyringe';
import type { App } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';
import routes from '~pages';

@injectable()
@singleton()
@registry([{ token: AppModuleToken, useToken: RouterModule }])
class RouterModule implements AppModule {
  private readonly router = createRouter({
    history: createWebHashHistory(import.meta.env.BASE_URL),
    routes: [
      ...routes,
      {
        path: '/',
        component: import('@/views/DashboardView.vue')
      }
    ]
  });
  setup(app: App): void {
    app.use(this.router);
  }
}

export { RouterModule };
