import {useAppDispatch} from "../../Redux/hooks.ts";
import {useEffect, useState} from "react";
import {getAllAlbums} from "./Store/albumSlice.ts";

export function AlbumList() {
	const dispatch = useAppDispatch();
	let [recipeList, setRecipeList] = useState<any[]>([]);

	useEffect(() => {
		let list: any = dispatch(getAllAlbums());
		setRecipeList(list);
		console.log(recipeList)
	}, []);


	return (
		<></>
	);
}