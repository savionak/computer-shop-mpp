package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;


public class ComponentModelEntitySupplier implements EntityLongSupplier<ComponentModel> {

    @Override
    public ComponentModel getValidEntityWithoutId() {
        ComponentModel result =  new ComponentModel();
        result.setId(null);
        result.setName(TestHelper.nextString());
        result.setDescription(TestHelper.nextString());
        return result;
    }

    @Override
    public ComponentModel getInvalidEntity() {
        return null;
    }

    @Override
    public Page<ComponentModel> getPage(List<ComponentModel> content) {
        Page<ComponentModel> result = new PageImpl<>(content);
        return result;
    }
}
