import CustomerList from "@/components/exercice2/customerList.vue";
import CustomerDisplay from "@/components/exercice2/customerDisplay.vue";
import {createRouter, createWebHashHistory} from "vue-router";

const routes = [
	{path: '/Customer-list', component: CustomerList},
	{path: '/Customer-details/:id', component: CustomerDisplay},
];

const router = createRouter({
	history: createWebHashHistory(),
	routes,
});

export default router;