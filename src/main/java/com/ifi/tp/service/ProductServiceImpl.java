package com.ifi.tp.service;

import com.ifi.tp.bo.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private RestTemplate restTemplate;
    private String productServiceUrl;

    @Autowired
    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductType> listProductsTypes() {
        var url = productServiceUrl + "/shop";
        var products = restTemplate.getForObject(url, ProductType[].class);
        return Arrays.asList(products);
    }

    @Override
    public ProductType getProductType(int id) {
        var url = productServiceUrl + "/shop/{id}";
        return restTemplate.getForObject(url, ProductType.class, id);
    }

    @Value("${product.service.url}")
    void setProductServiceUrl(String productServiceUrl) {
        this.productServiceUrl = productServiceUrl;
    }

}
