import type DependencyContainer from 'tsyringe/dist/typings/types/dependency-container';
import type { InjectionKey } from 'vue';

const containerSymbol = Symbol() as InjectionKey<DependencyContainer>;

const axiosSymbol = Symbol('axios');

export { axiosSymbol, containerSymbol };
