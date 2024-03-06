import {useRef} from "react";
import {useAppDispatch} from "../../Redux/hooks.ts";
import {addAlbumToDb} from "./Store/albumSlice.ts";

export function DbTest() {
	const testRef = useRef<HTMLInputElement>(null);

	const dispatch = useAppDispatch();

	function addToDb() {
		dispatch(addAlbumToDb({
			title: "test",
			releaseDate: '2021-01-01',
			artist: "test",
			score: 0,
			coverURL: "test"
		}))
	}

	return (
		<>
			<label htmlFor='test'> Test </label>
			<input id='test' type='text' ref={testRef} placeholder='test'/>

			<button onClick={() => {
				addToDb()
			}}>Ok
			</button>
		</>
	);
}