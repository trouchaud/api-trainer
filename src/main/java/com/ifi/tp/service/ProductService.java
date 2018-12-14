package com.ifi.tp.service;

import com.ifi.tp.bo.ProductType;

import java.util.List;

public interface ProductService {

    List<ProductType> listProductsTypes();
    ProductType getProductType(int id);

}
