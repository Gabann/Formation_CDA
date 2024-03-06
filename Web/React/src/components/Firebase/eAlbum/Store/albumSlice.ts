import {createSlice, PayloadAction} from '@reduxjs/toolkit';
import {IAlbum} from "../EAlbum.tsx";
import {database} from '../firebaseConfig.ts';
import {child, get, ref, set} from "firebase/database";
// @ts-ignore
import {v4 as uuidv4} from "uuid";

const initialState: any = {}

const entitySlice = createSlice({
	name: 'album',
	initialState,
	reducers: {
		addAlbumToDb: (state, action: PayloadAction<IAlbum>) => {
			const id = uuidv4();
			set(ref(database, 'album/' + id), {
				id: id,
				title: action.payload.title,
				releaseDate: action.payload.releaseDate,
				artist: action.payload.artist,
				score: action.payload.score,
				coverURL: action.payload.coverURL
			}).then(() => {

			}).catch((error: any) => {
				console.error(error);
			});
		},

		getAllAlbums: (state) => {
			get(child(ref(database), 'album')).then((snapshot) => {
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

export const {addAlbumToDb, getAllAlbums} = entitySlice.actions;

export default entitySlice.reducer;