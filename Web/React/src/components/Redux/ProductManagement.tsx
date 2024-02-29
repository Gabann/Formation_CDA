import {Provider} from "react-redux";
import {ProductStore} from "./productStore.ts";
import {ProductList} from "./ProductList.tsx";
import {AddProductForm} from "./AddProductForm.tsx";

export function ProductManagement() {
	return (
		<Provider store={ProductStore}>
			<ProductList></ProductList>
			<AddProductForm></AddProductForm>
		</Provider>
	);
}