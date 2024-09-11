export class Product {
    id: number;
    category: string;
    description: string;
    name: string;
    price: number;
    imageUrl: string;

    constructor(id: number, category: string, description: string, name: string, price: number, imageUrl: string) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
