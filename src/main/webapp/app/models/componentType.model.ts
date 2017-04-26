export class ComponentType {
    id?: number;
    name?: string;
    description?: string;
}

/*
export class ComponentType {
    constructor(private name: string, private description?: string, private id?: number) {
        if (id === null) {
            id = 0;
        }
    }
    
    public getId(): number {
        return this.id;
    }

    public setId(id: number): void {
        this.id = id;
    }
    
    public getName(): string {
        return this.name;
    }

    public setName(name: string): void {
        this.name = name;
    }

    public getDescription(): string {
        return this.description;
    }

    public setDescription(description: string): void {
        this.description = description;
    }

}
*/