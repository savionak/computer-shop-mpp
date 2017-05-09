export class Util {
    public static readonly STORAGE_KEY = 'computer-shop-mpp-user';

    public static copy(source: any): any {
        return JSON.parse(JSON.stringify(source));
    }
}