package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Export;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;


public class ExportEntitySupplier implements EntityLongSupplier<Export> {

    @Override
    public Export getValidEntityWithoutId() {
        Export result =  new Export();
        result.setId(null);
        result.setExportDate(TestHelper.getCurrentTimestamp());
        result.setAddress(TestHelper.nextString());
        return result;
    }

    @Override
    public Export getInvalidEntity() {
        return null;
    }


}
