import { QInput } from 'quasar';
import { defineComponent, onMounted, ref } from 'vue';

const Input = defineComponent({
  setup: () => {
    onMounted(() => {
      console.log('input mounted');
    });
  },
  render: () => {
    const value = ref<string | number | null | undefined>();
    return (
      <>
        <div className={['w-full', 'bg-amber-400', 'h-5'].join(' ')}></div>
        <QInput modelValue={value.value} />
      </>
    );
  },
});

export default Input;
