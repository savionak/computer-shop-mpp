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


export const DIRECTOR_ROUTES = {
    'default': ORDER + '/' + VIEW,
    'items': [
        {'name': 'Orders', 'path': ORDER + '/' + VIEW},
        {'name': 'Customers', 'path': CUSTOMER + '/' + VIEW},
        {'name': 'Store', 'path': STORE + '/' + VIEW},
        {'name': 'Imports', 'path': IMPORT + '/' + VIEW},
        {'name': 'Providers', 'path': PROVIDER + '/' + EDIT}
    ]
};

export const MANAGER_ROUTES = {
    'default': ORDER + '/' + EDIT,
    'items': [
        {'name': 'Orders', 'path': ORDER + '/' + EDIT},
        {'name': 'Customers', 'path': CUSTOMER + '/' + EDIT},
        {'name': 'Store', 'path': STORE + '/' + EDIT},
        {'name': 'Imports', 'path': IMPORT + '/' + EDIT},
        {'name': 'Models', 'path': MODEL + '/' + EDIT},
        {'name': 'Types', 'path': TYPE + '/' + VIEW},
        {'name': 'Providers', 'path': PROVIDER + '/' + VIEW}
    ]
};

export const ADMIN_ROUTES = {
    'default': USER + '/' + EDIT,
    'items': [
        {'name': 'Users', 'path': USER + '/' + EDIT},
        {'name': 'Orders', 'path': ORDER + '/' + EDIT},
        {'name': 'Customers', 'path': CUSTOMER + '/' + EDIT},
        {'name': 'Store', 'path': STORE + '/' + EDIT},
        {'name': 'Imports', 'path': IMPORT + '/' + EDIT},
        {'name': 'Models', 'path': MODEL + '/' + EDIT},
        {'name': 'Types', 'path': TYPE + '/' + EDIT},
        {'name': 'Providers', 'path': PROVIDER + '/' + EDIT}
    ]
};
