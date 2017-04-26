import {Component} from "@angular/core";
import {ComponentTypeModel} from "./component-type-model";


const COMPONENT_TYPES_LIST: ComponentTypeModel[] = [
    { id: 1, name: 'Processor', description: 'Very important thing!' },
    { id: 2, name: 'Motherboard' },
    { id: 3, name: 'HDD' },
    { id: 4, name: 'RAM' },
    { id: 5, name: 'Mouse' },
]

@Component({
    selector: 'comp-type-list',
    templateUrl: './component-type-list.component.html'
})
export class ComponentTypesListComponent  {
    title: string;
    componentTypes = COMPONENT_TYPES_LIST;

    newType: ComponentTypeModel = {};
    editingIndex: number;
    editingTypeCopy: ComponentTypeModel;

    onAdd(): void {
        this.componentTypes.push(this.newType);
        this.newType = {};
    }

    onDelete(type: ComponentTypeModel): void {
        this.componentTypes = this.componentTypes.filter((x) => { return x != type; });
    }

    onEdit(type: ComponentTypeModel): void {
        this.editingIndex = this.componentTypes.indexOf(type);
        this.editingTypeCopy = JSON.parse(JSON.stringify(type));
    }

    onSave(): void {
        this.componentTypes[this.editingIndex] = this.editingTypeCopy;
        this.endEditing();
    }

    onCancel(): void {
        this.endEditing();
    }

    endEditing(): void {
        this.editingTypeCopy = null;
        this.editingIndex = null;
    }
}
