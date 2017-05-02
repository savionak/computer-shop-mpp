package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;


public class ImportEntitySupplier implements EntityLongSupplier<Import> {

    @Override
    public Import getValidEntityWithoutId() {
        Import result =  new Import();
        result.setId(null);
        result.setImportDate(TestHelper.getCurrentTimestamp());
        result.setCount(TestHelper.nextLong());
        result.setPurchasePrice(TestHelper.nextLong());
        result.setPrice(TestHelper.nextLong());
        return result;
    }

    @Override
    public Import getInvalidEntity() {
        return null;
    }

}
