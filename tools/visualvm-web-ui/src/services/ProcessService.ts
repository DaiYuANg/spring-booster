import { axiosSymbol } from '@/types/inject';
import type { AxiosInstance } from 'axios';
import { inject, injectable, singleton } from 'tsyringe';
import type {Process} from "@/types";

@injectable()
@singleton()
class ProcessService {
  constructor(@inject(axiosSymbol) private readonly axios: AxiosInstance) {}

  public queryProcessInfo(processId: number):Promise<Process> {
    return this.axios.get('/process', {
      params: {
        processId
      }
    });
  }
}

export { ProcessService };
