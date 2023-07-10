import { api } from 'boot/axios';
import { SessionStorage } from 'quasar';

export const actuatorDetect = () => {
  return api.get('/dev/admin/detect');
};

export const mappings = () => {
  return api.get(SessionStorage.getItem('mappings')?.href);
};
