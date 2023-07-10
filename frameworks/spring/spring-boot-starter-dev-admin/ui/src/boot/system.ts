import { boot } from 'quasar/wrappers';
import { actuatorDetect } from 'src/api/actuator';
import { SessionStorage } from 'quasar';

// "async" is optional;
// more info on params: https://v2.quasar.dev/quasar-cli/boot-files
export default boot(async ({ router }) => {
  // something to do
  actuatorDetect().then((r) => {
    const data = r.data._links;
    for (const rKey in data) {
      SessionStorage.set(rKey, data[rKey]);
    }
  });
});
