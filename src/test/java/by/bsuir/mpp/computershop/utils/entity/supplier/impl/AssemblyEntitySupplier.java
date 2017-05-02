package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;


public class AssemblyEntitySupplier implements EntityLongSupplier<Assembly> {

    @Override
    public Assembly getValidEntityWithoutId() {
        Assembly result =  new Assembly();
        result.setId(null);
        result.setCost(TestHelper.nextLong());
        result.setCount(TestHelper.nextLong());
        return result;
    }

    @Override
    public Assembly getInvalidEntity() {
        return null;
    }

    @Override
    public Page<Assembly> getPage(List<Assembly> content) {
        Page<Assembly> result = new PageImpl<>(content);
        return result;
    }
}
