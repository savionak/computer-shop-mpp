package by.bsuir.mpp.computershop.dto.full;

import java.io.Serializable;

public abstract class BaseFullDto<ID extends Serializable> implements Serializable {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
