import {NavBar} from "./NavBar.tsx";
import {Provider} from "react-redux";
import {store} from "./Store/store.ts";
import {RecipeList} from "./RecipeList.tsx";

export interface Irecipe {
	id: string,
	title: string,
	instructions: string,
	cookTime: number,
	prepTime: number,
	ingredients: { id: number, name: string }[]
}

export interface IIngredient {
	id: number,
	name: string;
}

export function ERecipe() {
	return (
		<Provider store={store}>
			<NavBar/>
			{/*<LogIn/>*/}
			<RecipeList/>
			{/*<AddAlbum/>*/}

		</Provider>
	);
}