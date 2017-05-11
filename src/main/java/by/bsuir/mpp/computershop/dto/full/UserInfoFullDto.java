package by.bsuir.mpp.computershop.dto.full;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_EMPTY_MESSAGE;

public class UserInfoFullDto extends BaseFullDto<Long> {

    @SafeHtml
    @NotEmpty(message = CANNOT_BE_EMPTY_MESSAGE)
    private String firstName;

    @SafeHtml
    @NotEmpty(message = CANNOT_BE_EMPTY_MESSAGE)
    private String lastName;

    @SafeHtml
    private String patronymic;

    @SafeHtml
    private String phone;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
