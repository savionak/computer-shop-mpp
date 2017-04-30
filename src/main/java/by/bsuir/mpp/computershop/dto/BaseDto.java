package by.bsuir.mpp.computershop.dto;

import java.io.Serializable;

public abstract class BaseDto<ID extends Serializable> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
