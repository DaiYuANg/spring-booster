import { containerSymbol } from '@/types/inject';
import type { InjectionToken } from 'tsyringe';
import type DependencyContainer from 'tsyringe/dist/typings/types/dependency-container';
import { inject } from 'vue';

const useContainer = <T>(object: InjectionToken): T | undefined => {
  const container: DependencyContainer | undefined = inject(containerSymbol);
  return container?.resolve<T>(object);
};

export { useContainer };
