import type { Meta, StoryObj } from '@storybook/vue3';

import Input from './Input.vue';

// More on how to set up stories at: https://storybook.js.org/docs/vue/writing-stories/introduction
const meta = {
  title: 'Example/Input',
  component: Input,
  // This component will have an automatically generated docsPage entry: https://storybook.js.org/docs/vue/writing-docs/autodocs
  tags: ['autodocs'],
  argTypes: {
    size: { control: 'select', options: ['small', 'medium', 'large'] },
    backgroundColor: { control: 'color' },
  },
  args: { primary: true }, // default value
} satisfies Meta<typeof Input>;

export default meta;
type Story = StoryObj<typeof meta>;
/*
 *👇 Render functions are a framework specific feature to allow you control on how the component renders.
 * See https://storybook.js.org/docs/vue/api/csf
 * to learn how to use render functions.
 */
export const Primary: Story = {
  args: {
    primary: true,
    label: 'Input',
  },
};

export const Secondary: Story = {
  args: {
    primary: false,
    label: 'Input',
  },
};

export const Large: Story = {
  args: {
    label: 'Input',
    size: 'large',
  },
};

export const Small: Story = {
  args: {
    label: 'Input',
    size: 'small',
  },
};
