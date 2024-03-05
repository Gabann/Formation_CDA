import {useRef} from "react";
import {useAppDispatch} from "../Redux/hooks.ts";
import {addToDB} from "./Store/recipeSlice.ts";

export function DbTest() {
	const testRef = useRef<HTMLInputElement>(null);

	const dispatch = useAppDispatch();

	function addToDb() {
		dispatch(addToDB({
			id: "2",
			title: "test",
			instructions: "test",
			cookTime: 1,
			prepTime: 1,
			ingredients: [{id: 1, name: testRef.current?.value || ""}]
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