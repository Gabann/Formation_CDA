import React from 'react'
import ReactDOM from 'react-dom/client'
import {DevSupport} from "@react-buddy/ide-toolbox";
import {ComponentPreviews, useInitial} from "./dev";
import router from "./router/router.tsx";
import {RouterProvider} from "react-router-dom";

ReactDOM.createRoot(document.getElementById('root')!).render(
	<React.StrictMode>
		<DevSupport ComponentPreviews={ComponentPreviews}
		            useInitialHook={useInitial}>
			<RouterProvider router={router}/>
		</DevSupport>
	</React.StrictMode>,
)
