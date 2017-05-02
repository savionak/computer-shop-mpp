package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;


public class ComponentStoreEntitySupplier implements EntityLongSupplier<ComponentStore> {

    @Override
    public ComponentStore getValidEntityWithoutId() {
        ComponentStore result =  new ComponentStore();
        result.setId(null);
        result.setPrice(TestHelper.nextLong());
        result.setCount(TestHelper.nextLong());
        return result;
    }

    @Override
    public ComponentStore getInvalidEntity() {
        return null;
    }


}
