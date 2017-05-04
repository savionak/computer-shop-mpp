import {BaseModel} from "../base-model";
import {ComponentStoreBriefModel} from "../brief/component-store-brief-model";


export class AssemblyComponentModel extends BaseModel {
    assemblyId: number;
    component: ComponentStoreBriefModel;
    count: number;

    public static empty(): AssemblyComponentModel {
        return {id: null, assemblyId: null, component: null, count: null}
    }
}