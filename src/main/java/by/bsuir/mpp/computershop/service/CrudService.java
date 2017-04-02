package by.bsuir.mpp.computershop.service;

import java.io.Serializable;

public interface CrudService<E, ID extends Serializable> {
    E add(E type);
    Iterable<E> getAll();
    E getOne(ID id);
    void delete(ID id);
    E update(ID id, E type);
}
