import { Meta, StoryObj } from '@storybook/vue3';
import { CentralLayout } from './index.ts';

const meta = {
  title: 'Example/Layout',
  component: CentralLayout,
  // This component will have an automatically generated docsPage entry: https://storybook.js.org/docs/vue/writing-docs/autodocs
  tags: ['autodocs'],
  argTypes: {
    size: { control: 'select', options: ['small', 'medium', 'large'] },
    backgroundColor: { control: 'color' },
  },
  args: { primary: true }, // default value
} satisfies Meta<typeof CentralLayout>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    primary: false,
    label: 'Input',
  },
};
