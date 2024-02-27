import './global.css'
import {Outlet} from "react-router-dom";
import React from "react";
import {FooterComponent} from "./components/FooterComponent.tsx";
import {HeaderComponent} from "./components/HeaderComponent.tsx";

function App() {
	return (
		<div>
			<div className='container-fluid'>
				<HeaderComponent/>

				<div className="col-10 mx-auto">
					<Outlet/>
				</div>

				<FooterComponent/>
			</div>
		</div>
	);
}

export default App