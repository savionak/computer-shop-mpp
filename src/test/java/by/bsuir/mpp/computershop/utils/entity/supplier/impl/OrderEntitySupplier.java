package by.bsuir.mpp.computershop.utils.entity.supplier.impl;

import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntityLongSupplier;

import static by.bsuir.mpp.computershop.utils.TestHelper.RANDOM;


public class OrderEntitySupplier implements EntityLongSupplier<Order> {

    @Override
    public Order getValidEntityWithoutId() {
        Order result =  new Order();
        result.setId(null);
        result.setCost(0L);
        result.setOrderDate(TestHelper.getCurrentTimestamp());
        result.setStatus(Order.Status.VALUES.get(RANDOM.nextInt(Order.Status.SIZE)));
        return result;
    }

    @Override
    public Order getInvalidEntity() {
        return null;
    }


}
