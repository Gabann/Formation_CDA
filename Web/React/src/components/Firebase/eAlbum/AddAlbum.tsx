import {useRef} from "react";
import {useAppDispatch} from "../../Redux/hooks.ts";
import {addAlbumToDb} from "./Store/albumSlice.ts";

export function AddAlbum() {
	const albumNameRef = useRef<HTMLInputElement>(null);
	const albumArtistRef = useRef<HTMLInputElement>(null);
	const albumScoreRef = useRef<HTMLInputElement>(null);
	const albumCoverUrlRef = useRef<HTMLInputElement>(null);
	const albumReleaseDateRef = useRef<HTMLInputElement>(null);

	const dispatch = useAppDispatch();

	function addToDb() {
		if (albumCoverUrlRef.current?.value && albumNameRef.current?.value && albumArtistRef.current?.value && albumScoreRef.current?.value && albumReleaseDateRef.current?.value) {
			dispatch(addAlbumToDb({
				title: albumNameRef.current.value,
				releaseDate: albumReleaseDateRef.current.value,
				artist: albumArtistRef.current.value,
				score: parseInt(albumScoreRef.current.value),
				coverURL: albumCoverUrlRef.current.value
			}))
		}
	}

	return (
		<>
			<label htmlFor='album-name'> Album name </label>
			<input id='album-name' type='text' ref={albumNameRef} placeholder='Album name'/>

			<label htmlFor='album-artist'> Album artist </label>
			<input id='album-artist' type='text' ref={albumArtistRef} placeholder='Album artist'/>

			<label htmlFor='album-score'> Album score </label>
			<input id='album-score' type='number' ref={albumScoreRef} placeholder='Album score'/>

			<label htmlFor='album-cover-url'> Album cover URL </label>
			<input id='album-cover-url' type='text' ref={albumCoverUrlRef} placeholder='Album cover URL'/>

			<label htmlFor='album-release-date'> Album release date </label>
			<input id='album-release-date' type='date' ref={albumReleaseDateRef} placeholder='Album release date'/>

			<button onClick={() => {
				addToDb()
			}}>Add album
			</button>
		</>
	);
}