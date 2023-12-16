import type { AppModule } from '@/types/app.module';
import { AppModuleToken } from '@/types/app.module';
import { axiosSymbol } from '@/types/inject';
import type { AxiosInstance } from 'axios';
import axios from 'axios';
import { Loading } from 'quasar';
import { container, injectable, registry } from 'tsyringe';
import type { App } from 'vue';

const axiosInstance: AxiosInstance = axios.create({
  baseURL: '/api'
});

axiosInstance.interceptors.request.use((req) => {
  Loading.show();
  return req;
});

axiosInstance.interceptors.response.use((resp) => {
  Loading.hide();
  return resp.data;
});

@injectable()
@registry([{ token: AppModuleToken, useToken: AxiosModule }])
class AxiosModule implements AppModule {
  setup(app: App): void {
    app.config.globalProperties.$axios = axios;
    //   // ^ ^ ^ this will allow you to use this.$axios (for Vue Options API form)
    //   //       so you won't necessarily have to import axios in each vue file
    //
    app.config.globalProperties.$api = axiosInstance;
    container.registerInstance(axiosSymbol, axiosInstance);
  }
}

export { AxiosModule };
