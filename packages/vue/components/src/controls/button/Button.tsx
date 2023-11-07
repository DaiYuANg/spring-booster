import { QBtn } from 'quasar';
import { defineComponent } from 'vue';

const InternalButton = () => {
  return (
    <>
      <QBtn>Button</QBtn>
    </>
  );
};

export default defineComponent({
  render: () => {
    return (
      <>
        <InternalButton />
      </>
    );
  },
});
