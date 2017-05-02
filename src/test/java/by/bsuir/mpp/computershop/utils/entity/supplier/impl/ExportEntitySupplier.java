package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Export;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;


public class ExportEntitySupplier implements EntityLongSupplier<Export> {

    @Override
    public Export getValidEntityWithoutId() {
        Export result =  new Export();
        result.setId(null);
        result.setExportDate(TestHelper.currentTimeMillis());
        result.setAddress(TestHelper.nextString());
        return result;
    }

    @Override
    public Export getInvalidEntity() {
        return null;
    }

    @Override
    public Page<Export> getPage(List<Export> content) {
        Page<Export> result = new PageImpl<>(content);
        return result;
    }
}
