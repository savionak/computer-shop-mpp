export class ComponentTypeModel {
    id: number;
    name: string;
    description: string;

    public static empty():ComponentTypeModel {
        return { id: null, name: null, description: null}
    }
}

