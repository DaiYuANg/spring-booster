import {request} from "@/api/request";
import type {Process} from "@/types";



export const queryProcessInfo = (processId: number): Promise<Process> => {
    return request.get("/process", {
        params: {
            processId
        }
    })
}
