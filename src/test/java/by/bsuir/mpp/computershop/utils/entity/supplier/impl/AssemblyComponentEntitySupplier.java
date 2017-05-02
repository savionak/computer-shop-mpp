package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;


public class AssemblyComponentEntitySupplier implements EntityLongSupplier<AssemblyComponent> {

    @Override
    public AssemblyComponent getValidEntityWithoutId() {
        AssemblyComponent result =  new AssemblyComponent();
        result.setId(null);
        result.setCount(TestHelper.nextLong());

        return result;
    }

    @Override
    public AssemblyComponent getInvalidEntity() {
        return null;
    }

    @Override
    public Page<AssemblyComponent> getPage(List<AssemblyComponent> content) {
        Page<AssemblyComponent> result = new PageImpl<>(content);
        return result;
    }
}
