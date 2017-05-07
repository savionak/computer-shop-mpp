package by.bsuir.mpp.computershop.dto.full;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_EMPTY_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class UpdatePassDto {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Long userId;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @NotEmpty(message = CANNOT_BE_EMPTY_MESSAGE)
    private String newHash;

    public String getNewHash() {
        return newHash;
    }

    public void setNewHash(String newHash) {
        this.newHash = newHash;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
