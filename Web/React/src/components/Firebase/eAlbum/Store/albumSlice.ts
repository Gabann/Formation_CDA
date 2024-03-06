import {createAsyncThunk, createSlice, PayloadAction} from '@reduxjs/toolkit';
import {IAlbum} from "../EAlbum.tsx";
import {database} from '../firebaseConfig.ts';
import {child, get, ref, set} from "firebase/database";
// @ts-ignore
import {v4 as uuidv4} from "uuid";

export const getAllAlbums = createAsyncThunk('album/getAllAlbums', async (_, thunkAPI) => {
		try {
			const snapshot = await get(child(ref(database), 'album'));
			if (snapshot.exists()) {
				return snapshot.val();
			} else {
				console.log("No data available");
				return {};
			}
		} catch (error) {
			console.error(error);
			return thunkAPI.rejectWithValue(error);
		}
	}
);

const initialState: any = {}

const albumSlice = createSlice({
	name: 'album',
	initialState,
	reducers: {
		addAlbumToDb: (state, action: PayloadAction<IAlbum>) => {
			try {
				const id = uuidv4();
				set(ref(database, 'album/' + id), {
					id: id,
					title: action.payload.title,
					releaseDate: action.payload.releaseDate,
					artist: action.payload.artist,
					score: action.payload.score,
					coverURL: action.payload.coverURL
				}).catch((error: any) => {
					console.error(error);
				});
			} catch (error) {
				console.error(error);
			}
		},
	},
	extraReducers: (builder) => {
		builder.addCase(getAllAlbums.fulfilled, (state, action) => {
			state.albums = action.payload;
		});
	},
});

export const {addAlbumToDb} = albumSlice.actions;

export default albumSlice.reducer;