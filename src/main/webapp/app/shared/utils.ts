export class Util {
    public static copy(source: any): any {
        return JSON.parse(JSON.stringify(source));
    }
}