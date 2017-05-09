import {UserBriefModel} from "../model/brief/user-brief-model";

export class CurrentUser {
    access_token: string;
    expires_in: number;
    refresh_token: string;
    scope: string;
    token_type: string;
    user: UserBriefModel;
}
