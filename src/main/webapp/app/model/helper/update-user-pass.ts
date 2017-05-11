export class UpdateUserPass {
    userId: number;
    newHash: string;

    constructor(userId: number) {
        this.userId = userId;
    }
}