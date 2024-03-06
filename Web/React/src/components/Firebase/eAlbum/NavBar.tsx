export function NavBar() {
	return (
		<nav>
			<span>eAlbums</span>

			<div style={{float: 'right'}}>
				<label>Filter by: </label>
				<input type="text"/>
			</div>
		</nav>
	);
}