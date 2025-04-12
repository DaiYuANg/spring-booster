import instance, {Resp} from "./request.ts";

const cpuUsage = () => {
  return instance.get<null, Resp<number>>("/cpu/usage")
}

export {cpuUsage}