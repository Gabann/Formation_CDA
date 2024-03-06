import {NavBar} from "./NavBar.tsx";
import {AlbumList} from "./AlbumList.tsx";
import {LogIn} from "./LogIn.tsx";

export interface IAlbum {
	id?: string;
	title: string;
	releaseDate: string;
	artist: string;
	score: number;
	coverURL: string;
}

export function EAlbum() {
	return (
		<>
			<NavBar/>
			<LogIn/>
			<AlbumList/>
		</>
	)
}