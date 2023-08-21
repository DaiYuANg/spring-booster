import axios, {AxiosRequestConfig} from "axios";

const api = axios.create({ baseURL: '/api' });

api.interceptors.response.use(
  (resp): any => {
    return resp.data;
  },
  (e) => {
    console.log(e);
  }
);

api.interceptors.request.use(
  (r) => {
    return r;
  },
  (e) => {
    console.log(e);
  }
);

export const request = (config?:AxiosRequestConfig)=>{
  return api.request(config!)
}


export {api}
