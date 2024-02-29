import {IProduct} from "./productSlice.ts";
import {Product} from "./Product.tsx";
import {useAppSelector} from "./hooks.ts";

export function ProductList() {
	let products = useAppSelector(state => state.productSlice)
	return (
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				{products.map((product: IProduct) => (
					<Product key={product.id} {...product}/>
				))}
			</tbody>
		</table>

	)
}