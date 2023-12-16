import axios from "axios";
import {Loading} from "quasar";

const request = axios.create({
    baseURL: "/api"
})

request.interceptors.request.use(req => {
    Loading.show()
    return req
})

request.interceptors.response.use(resp => {
    Loading.hide()
    return resp.data
})

export {request}