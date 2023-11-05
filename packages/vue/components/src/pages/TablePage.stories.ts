import { Meta, StoryObj } from '@storybook/vue3';
import TablePage from './TablePage.vue';

const meta = {
  title: 'Layout/TablePage',
  component: TablePage,
  // This component will have an automatically generated docsPage entry: https://storybook.js.org/docs/vue/writing-docs/autodocs
  tags: ['autodocs'],
  argTypes: {
    tableProp: {},
  },
  args: {}, // default value
} satisfies Meta<typeof TablePage>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    tableProp: {
      rows: [{ test: 123 }],
      fullscreen: false,
    },
  },
};
