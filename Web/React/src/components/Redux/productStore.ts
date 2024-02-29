import {configureStore} from "@reduxjs/toolkit";
import productSlice from './productSlice.ts'

export const ProductStore = configureStore({
	reducer: {
		productSlice
	}
})

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof ProductStore.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof ProductStore.dispatch