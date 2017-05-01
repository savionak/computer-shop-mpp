package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ProviderEntitySupplier implements EntityLongSupplier<Provider> {

    @Override
    public Provider getValidEntityWithoutId() {
        Provider result =  new Provider();
        result.setId(null);
        result.setName(TestHelper.nextString());
        result.setDescription(TestHelper.nextString());
        return result;
    }

    @Override
    public Provider getInvalidEntity() {
        return null;
    }

    @Override
    public Page<Provider> getPage(List<Provider> content) {
        Page<Provider> result = new PageImpl<>(content);
        return result;
    }
}
