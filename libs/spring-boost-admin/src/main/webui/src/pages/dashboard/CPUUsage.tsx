import {ResourceCard} from "../../component/ResourceCard.tsx";
import {useQuery} from "@tanstack/react-query";
import {cpuUsage} from "../../api/system.ts";

const CPUUsage = () => {

  const {data} = useQuery({
    queryKey: ['cpu', 'usage'],
    queryFn: cpuUsage,
    refetchIntervalInBackground: true,
    refetchInterval: 2000,
  })
  console.log(data)
  if (data === undefined) {
    return <>
      Waiting</>
  }
  return <>
    <ResourceCard title={"CPU"} usage={data.data}/>
  </>
}

export {CPUUsage}