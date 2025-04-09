import axios from "axios";
import type {HttpError} from "@refinedev/core";
import {TOKEN_KEY} from "../../authProvider";

const axiosInstance = axios.create({
  baseURL: '/api'
});

axiosInstance.interceptors.request.use((request)=>{
  const token = localStorage.getItem(TOKEN_KEY)
  request.headers.authorization = "Bearer "+token;
  console.log(request.headers);
  return request;
})

axiosInstance.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    const customError: HttpError = {
      ...error,
      message: error.response?.data?.message,
      statusCode: error.response?.status,
    };

    return Promise.reject(customError);
  }
);

export {axiosInstance};
