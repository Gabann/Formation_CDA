import {IAlbum} from "./EAlbum.tsx";

function displayStar(score: number) {
	let content = []
	for (let i = 0; i < Math.min(score, 5); i++) {
		content.push(<span key={i}>⭐</span>)
	}

	return content;
}

export function Album(props: Readonly<IAlbum>) {
	return (
		<div style={{outline: '2px solid black', padding: 10}}>
			<h2>{props.title}</h2>
			<img style={{maxWidth: '100%',}} src={props.coverURL} alt={props.title}/>
			<p>Artist: {props.artist}</p>
			<p>Release date: {props.releaseDate}</p>
			<p>Score: {displayStar(props.score)}</p>
		</div>
	);
}