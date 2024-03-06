import {useAppDispatch} from "../../Redux/hooks.ts";
import {useEffect, useState} from "react";
import {getAllAlbums} from "./Store/albumSlice.ts";
import {Album} from "./Album.tsx";
import {IAlbum} from "./EAlbum.tsx";
import {NavLink} from "react-router-dom";

export function AlbumList() {
	const dispatch = useAppDispatch();
	let [albumList, setAlbumList] = useState<IAlbum[]>([]);

	useEffect(() => {
		(async () => {
			try {
				let list = await dispatch(getAllAlbums()).unwrap();
				setAlbumList(Object.values(list));
			} catch (error) {
				console.error('Failed to fetch albums: ', error);
			}
		})();
	}, []);

	return (
		<>
			<NavLink to="/Ealbum/add">
				<button>Add album</button>
			</NavLink>

			<div className='d-flex flex-wrap col-12'>
				{albumList.map((album) => (
					<div key={album.id} className="col-xl-3 col-md-4 col-sm-6 col-12 p-3">
						<Album {...album}/>
					</div>
				))}
			</div>
		</>
	);
}