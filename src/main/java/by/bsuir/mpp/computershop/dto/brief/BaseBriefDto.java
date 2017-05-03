package by.bsuir.mpp.computershop.dto.brief;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public abstract class BaseBriefDto<ID extends Serializable> {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
