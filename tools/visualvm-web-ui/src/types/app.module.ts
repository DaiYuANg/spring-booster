import type { App } from 'vue';

const AppModuleToken = Symbol('Module');

interface AppModule {
  setup(app: App): void;
}

export { AppModuleToken };
export type { AppModule };
