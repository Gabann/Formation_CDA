import {createBrowserRouter} from "react-router-dom";
import {TicTacToe} from "../components/TicTacToe/TicTacToe.tsx";
import ErrorPage from "../components/ErrorPage.tsx";
import {FizzBuzz} from "../components/FizzBuzz.tsx";
import {Multiplicator} from "../components/Multiplicator.tsx";
import {TodoList} from "../components/TodoList/TodoList.tsx";
import React from "react";
import App from "../App.tsx";
import {RefTextBox} from "../components/RefTextBox.tsx";
import {Directory} from "../components/DirectoryExercice/Directory.tsx";
import {Context} from "../components/ContextExercice/Context.tsx";
import {RoutingParams} from "../components/RoutingParams/RoutingParams.tsx";
import {Api as ApiTP1} from "../components/Api/TP1/Api.tsx";
import {Api as ApiTP2} from "../components/Api/TP2/Api.tsx";
import {BookDetails} from "../components/Api/TP2/BookDetails.tsx";
import {ProductManagement} from "../components/Redux/ProductManagement.tsx";
import {ERecipe} from "../components/Firebase/ERecipe.tsx";

export const routes = [
	{path: "/TicTacToe", component: TicTacToe},
	{path: "/FizzBuzz", component: FizzBuzz},
	{path: "/Multiplicator", component: Multiplicator},
	{path: "/TodoList", component: TodoList},
	// {path: "/LogIn", component: LogIn},
	{path: "/RefTextBox", component: RefTextBox},
	{path: "/Directory", component: Directory},
	{path: "/Context", component: Context},
	{path: "/RoutingParams/:id", component: RoutingParams},
	{path: "/Api-tp1", component: ApiTP1},
	{path: "/Api-tp2", component: ApiTP2},
	{path: "/book-detail/:id", component: BookDetails},
	{path: "/products", component: ProductManagement},
	{path: "/eRecipe", component: ERecipe},
	// {path: "/eRecipe/login", component: LogIn},
];

const router = createBrowserRouter([
	{
		path: "/",
		element: <App/>,
		errorElement: <ErrorPage/>,
		children: routes.map(({path, component}) => ({
			path,
			element: React.createElement(component),
		})),
	},
]);

export default router