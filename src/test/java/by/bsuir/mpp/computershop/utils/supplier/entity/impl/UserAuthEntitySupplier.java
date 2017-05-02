package by.bsuir.mpp.computershop.utils.supplier.entity.impl;

import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntityLongSupplier;

import static by.bsuir.mpp.computershop.utils.TestHelper.RANDOM;

public class UserAuthEntitySupplier implements EntityLongSupplier<UserAuth> {

    @Override
    public UserAuth getValidEntityWithoutId() {
        UserAuth result = new UserAuth();
        result.setId(null);
        result.setEmail(TestHelper.nextString());
        result.setPassHash(TestHelper.nextString());
        result.setRole(UserAuth.Role.VALUES.get(RANDOM.nextInt(UserAuth.Role.SIZE)));
        return result;
    }

    @Override
    public UserAuth getInvalidEntity() {
        return null;
    }


}
