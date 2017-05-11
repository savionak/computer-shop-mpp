export class UpdateStorePrice {
    id: number;
    newPrice: number;
    newCount: number;

    constructor(storeId: number, count?: number, price?: number) {
        this.id = storeId;
        this.newCount = count || 0;
        this.newPrice = price || 0;
    }
}