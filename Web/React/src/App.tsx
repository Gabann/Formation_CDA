import './global.css'
import {Outlet} from "react-router-dom";
import React from "react";
import {FooterComponent} from "./components/FooterComponent.tsx";
import {HeaderComponent} from "./components/HeaderComponent.tsx";
import {store} from "./store.ts";
import {Provider} from "react-redux";

function App() {
	return (
		<Provider store={store}>
			<div>
				<HeaderComponent/>

				<div className="col-10 mx-auto">
					<Outlet/>
				</div>

				<FooterComponent/>
			</div>
		</Provider>
	);
}

export default App