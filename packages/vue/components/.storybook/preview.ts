import type { Preview } from '@storybook/vue3';
// Import icon libraries
import '@quasar/extras/material-icons/material-icons.css';
// Import Quasar css
import { setup } from '@storybook/vue3';
import { Quasar } from 'quasar';
import 'quasar/src/css/index.sass';

const preview: Preview = {
  parameters: {
    actions: { argTypesRegex: '^on[A-Z].*' },
    controls: {
      matchers: {
        color: /(background|color)$/i,
        date: /Date$/,
      },
    },
  },
};
setup((app) => {
  app.use(Quasar, {});
});
export default preview;
