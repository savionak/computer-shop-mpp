import {Injectable} from "@angular/core";

import {ComponentTypeModel} from "./component-type-model";

@Injectable()
export class ComponentTypeService {

    componentTypes: ComponentTypeModel[] = [
        { id: 1, name: 'Processor', description: 'Very important thing!' },
        { id: 2, name: 'Motherboard', description: null },
        { id: 3, name: 'HDD', description: null },
        { id: 4, name: 'RAM', description: null },
        { id: 5, name: 'Mouse', description: null },
    ];

    add(type: ComponentTypeModel): void {
        this.componentTypes.push(type);
    }

    remove(type: ComponentTypeModel): void {
        this.componentTypes = this.componentTypes.filter((x) => { return x != type; });
    }

    update(index: number, type: ComponentTypeModel): void {
        this.componentTypes[index] = type;
    }

    getList(): ComponentTypeModel[] {
        return this.componentTypes;
    }

    get(index: number): ComponentTypeModel {
        return this.componentTypes[index];
    }

    indexOf(type: ComponentTypeModel): number {
        return this.componentTypes.indexOf(type);
    }
}
