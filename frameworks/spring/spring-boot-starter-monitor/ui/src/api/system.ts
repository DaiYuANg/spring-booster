import {api} from 'boot/axios';

const basePath = "/dev/admin"

export const memory = () => {
  return api.get(basePath + '/system/memoryAboutJvm');
};

export const threads = () => {
  return api.get(basePath + '/system/threads');
};
