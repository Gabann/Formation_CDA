import {useContext} from "react";
import {ApiContext} from "./Api.tsx";
import {NavLink} from "react-router-dom";

export function BookList() {
	let apiContext = useContext(ApiContext);

	return (
		<div className='d-flex flex-wrap'>
			{apiContext?.bookList.map((book, index: number) => {
					return (
						<NavLink key={index} to={{pathname: `/Book-detail/${index}`}}>
							<div className="col-xl-3 col-md-4 col-sm-6 col-12 p-3">
								<img src={`https://covers.openlibrary.org/b/id/${book.coverUrlId}-L.jpg`}
								     className="card-img-top"/>
								<p>{book.title}</p>
							</div>
						</NavLink>
					)
				}
			)}
		</div>
	);
}