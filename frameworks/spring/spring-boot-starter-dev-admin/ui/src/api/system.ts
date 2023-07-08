import { api } from 'boot/axios';

export const memory = () => {
  return api.get('/system/memory');
};

export const threads = () => {
  return api.get('/system/threads');
};
