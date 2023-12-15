import {createRouter, createWebHistory} from "vue-router";
import CustomerList from "@/components/exercice2/customerList.vue";
import CustomerDetails from "@/components/exercice2/customerDetails.vue";
import NotFound from "@/components/NotFound.vue";
import TodoListView from "@/components/TodoListStore/todoListView.vue";

const routes = [
	{path: '/:pathMatch(.*)*', redirect: 'not-found'},
	{path: '/not-found', component: NotFound},
	{path: '/', redirect: "customer-List"},
	{path: '/customer-list', component: CustomerList},
	{path: '/customer-details/:id', component: CustomerDetails},
	{path: '/todo-list', component: TodoListView},
];

const router = createRouter({
	history: createWebHistory(),
	routes,
});

export default router;