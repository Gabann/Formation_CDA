import {createSlice, PayloadAction} from '@reduxjs/toolkit';
import {Irecipe} from "../ERecipe.tsx";
import {database} from '../firebaseConfig.ts';
import {child, get, ref, set} from "firebase/database";


const initialState: any = {}

const entitySlice = createSlice({
	name: 'auth',
	initialState,
	reducers: {
		addAlbumToDb: (state, action: PayloadAction<Irecipe>) => {
			set(ref(database, 'recipe/' + action.payload.id), {
				id: action.payload.id,
				title: action.payload.title,
				instructions: action.payload.instructions,
				cookTime: action.payload.cookTime,
				prepTime: action.payload.prepTime,
				ingredients: action.payload.ingredients
			});

		},
		getAllAlbums: (state) => {
			get(child(ref(database), 'recipe')).then((snapshot) => {
				if (snapshot.exists()) {
					console.log(snapshot.val());
					return snapshot.val();
				} else {
					console.log("No data available");
				}
			}).catch((error: any) => {
				console.error(error);
			});
		}
	},
});

export const {addToDB, getAllRecipes} = entitySlice.actions;

export default entitySlice.reducer;