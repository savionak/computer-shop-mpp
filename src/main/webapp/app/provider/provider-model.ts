export class ProviderModel{
    id: number;
    name: string;
    description: string;

    public static empty():ProviderModel {
        return { id: null, name: null, description: null}
    }
}