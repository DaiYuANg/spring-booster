import type {RouteRecordRaw} from "vue-router";

const routes:Array<RouteRecordRaw> = [
    {
        path:"/",
        component:()=>import("@/views/DashboardView.vue"),
        meta:{
            icon: 'dashboard'
        }
    },
    {
        path: '/system/service',
        name: 'systemService',
        // route level code-splitting
        // this generates a separate chunk (About.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('@/views/SystemService.vue')
    },
    {
        path:'/terminal',
        name:'terminal',
        component:()=>import('@/views/TerminalView.vue')
    }
]

export {routes}