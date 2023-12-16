import {useWebNotification} from "@vueuse/core";
import {useQuasar} from "quasar";

type notificationProp = {

}
const useNotification = async () => {
    const $q = useQuasar()
    const {isSupported, show} = useWebNotification({})

    if (!isSupported) {
        $q.notify({})
    } else {
        await show({})
    }
}

export type {notificationProp}
export {useNotification}