import {api} from 'boot/axios';
import {Hardware} from "src/types/Hardware";

const basePath = "/system"

export const memory = () => {
  return api.get(basePath + '/memoryAboutJvm');
};

export const threads = () => {
  return api.get(basePath + '/threads');
};

export const hardware = () => {
  return api.get<Hardware>(basePath + '/hardware');
};

export const operationSystem = ()=>{
  return api.get(basePath+"/operationSystem")
}
