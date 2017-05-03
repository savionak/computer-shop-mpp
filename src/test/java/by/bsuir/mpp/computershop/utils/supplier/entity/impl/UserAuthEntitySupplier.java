package by.bsuir.mpp.computershop.utils.supplier.entity.impl;

import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.entity.UserInfo;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntityLongSupplier;


public class UserAuthEntitySupplier implements EntityLongSupplier<UserAuth> {

    @Override
    public UserAuth getValidEntityWithoutId() {
        UserAuth result = new UserAuth();
        result.setId(null);
        result.setEmail(TestHelper.nextString());
        result.setPassHash(TestHelper.nextString());
        result.setRole(UserAuth.Role.VALUES.get(TestHelper.RANDOM.nextInt(UserAuth.Role.SIZE)));
        result.setUserInfo(this.getUserInfo());
        return result;
    }

    @Override
    public UserAuth getInvalidEntity() {
        return null;
    }

    public UserInfo getUserInfo() {
        UserInfo info = new UserInfo();
        info.setFirstName(TestHelper.nextString());
        info.setLastName(TestHelper.nextString());
        return info;
    }
}
