package com.luka.bzj.goods.mapper;

import com.luka.bzj.goods.entity.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierMapper {

    void insert(Supplier supplier);
}
