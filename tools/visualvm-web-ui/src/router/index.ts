import {createMemoryHistory, createRouter, createWebHashHistory, createWebHistory} from 'vue-router'
import HomeView from '../views/DashboardView.vue'
import Layout from "@/components/Layout.vue";
import {routes} from "@/router/routes";

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: routes
})

export default router
