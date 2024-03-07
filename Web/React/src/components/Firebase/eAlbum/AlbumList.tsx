import {useAppDispatch} from "../../Redux/hooks.ts";
import {Album} from "./Album.tsx";
import {NavLink} from "react-router-dom";
import {useSelector} from "react-redux";
import {useEffect} from "react";
import {getAllAlbums} from "./Store/albumSlice.ts";
import {IAlbum} from "./EAlbum.tsx";

export function AlbumList() {
	const dispatch = useAppDispatch();
	const albumList = useSelector((state: any) => state.album.albumList);

	useEffect(() => {
		(async () => {
			try {
				await dispatch(getAllAlbums()).unwrap();
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
				{albumList.length > 0 && albumList.map((album: IAlbum) => (
					<div key={album.id} className="col-xl-3 col-md-4 col-sm-6 col-12 p-3">
						<Album {...album}/>
					</div>
				))}
			</div>
		</>
	);
}