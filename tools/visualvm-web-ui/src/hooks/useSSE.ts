import { useEventSource, type UseEventSourceOptions } from '@vueuse/core';

type useSSEProp = {
  url: string | URL;
  events?: Array<string>;
  options?: UseEventSourceOptions;
};
const useSSE = (prop: useSSEProp) => {
  useEventSource(prop.url, prop.events, prop.options);
};

export { useSSE };
