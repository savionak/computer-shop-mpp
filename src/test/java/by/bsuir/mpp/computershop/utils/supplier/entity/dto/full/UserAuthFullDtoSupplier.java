package by.bsuir.mpp.computershop.utils.supplier.entity.dto.full;

import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.dto.full.UserInfoFullDto;
import by.bsuir.mpp.computershop.entity.UserAuth;

import static by.bsuir.mpp.computershop.utils.TestHelper.RANDOM;
import static by.bsuir.mpp.computershop.utils.TestHelper.nextString;

public class UserAuthFullDtoSupplier implements FullDtoSupplier {

    public UserAuthFullDto getFullDto() {
        UserInfoFullDto info = new UserInfoFullDto();
        info.setFirstName(nextString());
        info.setLastName(nextString());

        UserAuthFullDto result = new UserAuthFullDto();
        result.setEmail(nextString());
        result.setPass(nextString());
        result.setRole(UserAuth.Role.VALUES.get(RANDOM.nextInt(UserAuth.Role.SIZE)));

        result.setUserInfo(info);
        return result;
    }
}
