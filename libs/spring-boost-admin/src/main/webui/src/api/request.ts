import axios from "axios";

const instance = axios.create({
  baseURL: "/api"
})

instance.interceptors.response.use(resp => {
  return resp.data;
})

type Resp<T> = {
  data: T
}

export default instance

export type {Resp}