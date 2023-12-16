import type { Service } from '@/types';
import { axiosSymbol } from '@/types/inject';
import type { AxiosInstance } from 'axios';
import { inject, injectable, singleton } from 'tsyringe';

@injectable()
@singleton()
class SystemInfoService {
  constructor(@inject(axiosSymbol) private readonly axios: AxiosInstance) {}

  public querySystemService(): Promise<Service[]> {
    return this.axios.get('/');
  }
}

export { SystemInfoService };
