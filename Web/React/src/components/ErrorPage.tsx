import {Link, useRouteError} from "react-router-dom";

const ErrorPage = () => {
	const error: any = useRouteError()
	return (
		<>
			<h1>Error : {error.status}</h1>
			<p>{error.data}</p>
			<Link to={"/"}>Home</Link>
		</>
	);
}

export default ErrorPage;