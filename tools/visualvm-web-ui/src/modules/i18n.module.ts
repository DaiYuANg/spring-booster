import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
import { injectable, registry, singleton } from 'tsyringe';
import type { App } from 'vue';
import { createI18n, type I18n } from 'vue-i18n';

@injectable()
@singleton()
@registry([{ token: AppModuleToken, useToken: I18nModule }])
class I18nModule implements AppModule {
  private readonly _i18n = createI18n({
    locale: 'en-US'
  });

  setup(app: App): void {
    app.use(this._i18n);
  }

  get i18n(): I18n {
    return this._i18n;
  }
}

export { I18nModule };
