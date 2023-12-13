import CustomerList from "@/components/exercice2/customerList.vue";
import CustomerDisplay from "@/components/exercice2/customerDisplay.vue";
import NotFound from "@/components/NotFound.vue";
import {createRouter, createWebHashHistory} from "vue-router";

const routes = [
	{path: '/:pathMatch(.*)*', component: NotFound},
	{path: '/Customer-list', component: CustomerList},
	{path: '/Customer-details/:id', component: CustomerDisplay},
];

const router = createRouter({
	history: createWebHashHistory(),
	routes,
});

export default router;