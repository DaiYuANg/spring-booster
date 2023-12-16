import {request} from "@/api/request";
import type {Service} from "@/types";

export const systemService = ():Promise<Service[]>=>{
    return request.get("/")
}


