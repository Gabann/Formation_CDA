import {useAppDispatch} from "../Redux/hooks.ts";
import {useEffect, useState} from "react";
import {getAllRecipes} from "./Store/recipeSlice.ts";

export function RecipeList() {
	const dispatch = useAppDispatch();
	let [recipeList, setRecipeList] = useState<any[]>([]);

	useEffect(() => {
		let list: any = dispatch(getAllRecipes());
		setRecipeList(list);
		console.log(recipeList)
	}, []);


	return (
		<></>
	);
}