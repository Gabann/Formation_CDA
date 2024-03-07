import {configureStore} from "@reduxjs/toolkit";
import authSlice from "./components/Firebase/eAlbum/Store/authSlice.ts";
import albumSlice from "./components/Firebase/eAlbum/Store/albumSlice.ts";
import recipeSlice from "./components/Firebase/eRecipe/Store/recipeSlice.ts";

export const store = configureStore({
	reducer: {
		auth: authSlice,
		album: albumSlice,
		recipe: recipeSlice
	}
})

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch