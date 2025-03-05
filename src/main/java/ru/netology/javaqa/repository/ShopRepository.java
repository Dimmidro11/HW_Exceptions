package ru.netology.javaqa.repository;

import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.exceptions.AlreadyExistsException;
import ru.netology.javaqa.exceptions.NotFoundException;

public class ShopRepository {
    private Product[]  products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        if (findById(product.getId()) == null) {
            products = addToArray(products, product);
        } else {
            throw new AlreadyExistsException("Element with id " + product.getId() + " already exists");
        }
    }

    public Product[] findAll() {
        return products;
    }

    public void remove(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copeToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copeToIndex] = product;
                copeToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }
}
