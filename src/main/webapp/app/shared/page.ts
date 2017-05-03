export class Page<T> {
    content: T[];
    info: PageInfo;
}

export class PageInfo {
    totalPages: number;
    number: number;
    isFirst: boolean;
    isLast: boolean;
    hasNext: boolean;
    hasPrevious: boolean;
    size: number;
    totalElements: number;
    numberOfElements: number;   // <= content.length
}