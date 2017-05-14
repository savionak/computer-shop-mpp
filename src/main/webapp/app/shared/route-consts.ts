import {Role} from "../model/full/user-auth-model";

export const LOGIN = 'login';

// Main routes
export const PROVIDER = 'provider';
export const TYPE = 'type';
export const MODEL = 'model';
export const STORE = 'store';
export const CUSTOMER = 'customer';
export const USER = 'user';
export const IMPORT = 'import';
export const ORDER = 'order';
export const ASSEMBLY = 'asm';

// Access type
export const ACCESS = 'access';
export const EDIT = 'edit';
export const VIEW = 'view';


const DIRECTOR_ROUTES = {
    'default': ORDER + '/' + VIEW,
    'items': [
        {'Orders': ORDER + '/' + VIEW},
        {'Customers': CUSTOMER + '/' + VIEW},
        {'Store': STORE + '/' + VIEW},
        {'Imports': IMPORT + '/' + VIEW},
        {'Providers': PROVIDER + '/' + EDIT}
    ]
};

const MANAGER_ROUTES = {
    'default': ORDER + '/' + EDIT,
    'items': [
        {'Orders': ORDER + '/' + EDIT},
        {'Customers': CUSTOMER + '/' + EDIT},
        {'Store': STORE + '/' + EDIT},
        {'Imports': IMPORT + '/' + EDIT},
        {'Models': MODEL + '/' + EDIT},
        {'Types': TYPE + '/' + VIEW},
        {'Providers': PROVIDER + '/' + VIEW}
    ]
};

const ADMIN_ROUTES = {
    'default': USER + '/' + EDIT,
    'items': [
        {'Users': USER + '/' + EDIT},
        {'Orders': ORDER + '/' + EDIT},
        {'Customers': CUSTOMER + '/' + EDIT},
        {'Store': STORE + '/' + EDIT},
        {'Imports': IMPORT + '/' + EDIT},
        {'Models': MODEL + '/' + EDIT},
        {'Types': TYPE + '/' + EDIT},
        {'Providers': PROVIDER + '/' + EDIT}
    ]
};


export const ROUTES = {};

ROUTES[Role.DIRECTOR] = DIRECTOR_ROUTES;
ROUTES[Role.MANAGER] = MANAGER_ROUTES;
ROUTES[Role.ADMIN] = ADMIN_ROUTES;
