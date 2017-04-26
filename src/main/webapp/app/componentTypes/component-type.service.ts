import {Injectable} from '@angular/core'

import {ComponentTypeModel} from './component-type-model'

@Injectable()
export class ComponentTypeService {

    componentTypes: ComponentTypeModel[] = [
        { id: 1, name: 'Processor', description: 'Very important thing!' },
        { id: 2, name: 'Motherboard' },
        { id: 3, name: 'HDD' },
        { id: 4, name: 'RAM' },
        { id: 5, name: 'Mouse' },
    ]

    add(type: ComponentTypeModel): void {
        this.componentTypes.push(type);
    }

    delete(type: ComponentTypeModel): void {
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
