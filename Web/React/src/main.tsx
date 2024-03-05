import React from 'react'
import ReactDOM from 'react-dom/client'
import router from "./router/router.tsx";
import {RouterProvider} from "react-router-dom";

console.log(import.meta.env.VITE_MAP_KEY)

ReactDOM.createRoot(document.getElementById('root')!).render(
	<React.StrictMode>
		<RouterProvider router={router}/>
	</React.StrictMode>,
)
