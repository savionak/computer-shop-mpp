package by.bsuir.mpp.computershop.utils.supplier.dto.full;

import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.dto.full.UserInfoFullDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.utils.TestHelper;


public class UserAuthFullDtoSupplier implements FullDtoSupplier {

    public UserAuthFullDto getFullDto() {
        UserInfoFullDto info = new UserInfoFullDto();
        info.setFirstName(TestHelper.nextString());
        info.setLastName(TestHelper.nextString());

        UserAuthFullDto result = new UserAuthFullDto();
        result.setEmail(TestHelper.nextString());
        result.setPass(TestHelper.nextString());
        result.setRole(UserAuth.Role.VALUES.get(TestHelper.RANDOM.nextInt(UserAuth.Role.SIZE)));

        result.setUserInfo(info);
        return result;
    }
}
