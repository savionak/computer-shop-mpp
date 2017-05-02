package by.bsuir.mpp.computershop.utils.entity.supplier;

import by.bsuir.mpp.computershop.entity.BaseEntity;

import java.util.Random;

public interface  EntityLongSupplier <E extends BaseEntity<Long>> extends EntitySupplier<E, Long>{
    @Override
    default Long getAnyId(){
        return new Random().longs(1,Long.MAX_VALUE).findFirst().getAsLong();
    }
}
