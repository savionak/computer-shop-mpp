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
    'default': {'path': ORDER, 'access': VIEW},
    'items': [
        {'name': 'Orders', 'path': ORDER, 'access': VIEW},
        {'name': 'Customers', 'path': CUSTOMER, 'access': VIEW},
        {'name': 'Store', 'path': STORE, 'access': VIEW},
        {'name': 'Imports', 'path': IMPORT, 'access': VIEW},
        {'name': 'Providers', 'path': PROVIDER, 'access': EDIT}
    ]
};

export const MANAGER_ROUTES = {
    'default': {'path': ORDER, 'access': EDIT},
    'items': [
        {'name': 'Orders', 'path': ORDER, 'access': EDIT},
        {'name': 'Customers', 'path': CUSTOMER, 'access': EDIT},
        {'name': 'Store', 'path': STORE, 'access': EDIT},
        {'name': 'Imports', 'path': IMPORT, 'access': EDIT},
        {'name': 'Models', 'path': MODEL, 'access': EDIT},
        {'name': 'Types', 'path': TYPE, 'access': VIEW},
        {'name': 'Providers', 'path': PROVIDER, 'access': VIEW}
    ]
};

export const ADMIN_ROUTES = {
    'default': {'path': USER, 'access': EDIT},
    'items': [
        {'name': 'Users', 'path': USER, 'access': EDIT},
        {'name': 'Orders', 'path': ORDER, 'access': EDIT},
        {'name': 'Customers', 'path': CUSTOMER, 'access': EDIT},
        {'name': 'Store', 'path': STORE, 'access': EDIT},
        {'name': 'Imports', 'path': IMPORT, 'access': EDIT},
        {'name': 'Models', 'path': MODEL, 'access': EDIT},
        {'name': 'Types', 'path': TYPE, 'access': EDIT},
        {'name': 'Providers', 'path': PROVIDER, 'access': EDIT}
    ]
};

export const GUEST_ROUTES = {
    'default': {'path': LOGIN, 'access': ""},
    'items': new Array(0)
};
