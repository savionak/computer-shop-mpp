import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./base/crud.service";
import {AssemblyComponentModel} from "../model/full/assembly-component-model";
import {AssemblyComponentBriefModel} from "../model/brief/assembly-component-brief-model";
import {Observable} from "rxjs/Observable";
import {Page} from "../model/page";


@Injectable()
export class AssemblyComponentService extends CrudService<AssemblyComponentModel, AssemblyComponentBriefModel> {
    constructor(http: HttpOAuthService) {
        super(http, AssemblyComponentService.asmUrl);
    }

    // url = assemblyId

    getList(url?: string): Observable<Page<AssemblyComponentBriefModel>> {
        return super.getList(this.formUrl(+url));
    }

    get(id: number, url?: string): Observable<AssemblyComponentModel> {
        return super.get(id, this.formUrl(+url));
    }

    add(model: AssemblyComponentModel, url?: string): Observable<AssemblyComponentModel> {
        return super.add(model, this.formUrl(+url));
    }

    remove(id: number, url?: string): Observable<AssemblyComponentModel> {
        return super.remove(id, this.formUrl(+url));
    }

    update(id: number, model: AssemblyComponentModel, url?: string): Observable<AssemblyComponentModel> {
        return super.update(id, model, this.formUrl(+url));
    }

    private formUrl(asmId: number): string {
        return AssemblyComponentService.asmUrl + '/' + asmId + '/' + AssemblyComponentService.comps;
    }

    static readonly asmUrl = '/api/assembly';
    static readonly comps = 'components';
}
