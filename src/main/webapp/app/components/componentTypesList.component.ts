import {Component} from "@angular/core";
import {ComponentType} from "../models/componentType.model";


const COMPONENT_TYPES_LIST: ComponentType[] = [
    { id: 1, name: 'Processor', description: 'Very important thing!' },
    { id: 2, name: 'Motherboard' },
    { id: 3, name: 'HDD' },
    { id: 4, name: 'RAM' },
    { id: 5, name: 'Mouse' },
]

@Component({
    selector: 'comp-type-list',
    template:
    `
    <div>
        <h2>Add type:</h2>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td><input [(ngModel)]="newType.id" placeholder="id" /></td>
                <td><input [(ngModel)]="newType.name" placeholder="Component name" /></td>
                <td><input [(ngModel)]="newType.description" placeholder="Component description" /></td>
            </tr>
        </table>
        <td><button type="button" (click)="onAdd()">Add</button></td>
    </div>
    <div *ngIf="editingTypeCopy">
        <h2>Edit type:</h2>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td><input [(ngModel)]="editingTypeCopy.id" placeholder="id" /></td>
                <td><input [(ngModel)]="editingTypeCopy.name" placeholder="Component name" /></td>
                <td><input [(ngModel)]="editingTypeCopy.description" placeholder="Component description" /></td>
            </tr>
        </table>
        <td><button type="button" (click)="onSave()">Save</button></td>
        <td><button type="button" (click)="onCancel()">Cancel</button></td>
    </div>
    <hr/>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th></th>
        </tr>
        <tr *ngFor="let type of componentTypes">
            <td>{{type.id}}</td>
            <td>{{type.name}}</td>
            <td>{{type.description}}</td>
            <td><button type="button" (click)="onEdit(type)">Edit</button></td>
            <td><button type="button" (click)="onDelete(type)">Delete</button></td>
        </tr>
    </table>
    `
})
export class ComponentTypesListComponent  {
    title: string;
    componentTypes = COMPONENT_TYPES_LIST;

    newType: ComponentType = {};
    editingIndex: number;
    editingTypeCopy: ComponentType;

    onAdd(): void {
        this.componentTypes.push(this.newType);
        this.newType = {};
    }

    onDelete(type: ComponentType): void {
        this.componentTypes = this.componentTypes.filter((x) => { return x != type; });
    }

    onEdit(type: ComponentType): void {
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
