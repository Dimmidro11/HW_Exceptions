package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.exceptions.AlreadyExistsException;
import ru.netology.javaqa.exceptions.NotFoundException;
import ru.netology.javaqa.repository.ShopRepository;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Футболка", 100);
    Product product2 = new Product(2, "Майка", 70);
    Product product3 = new Product(3, "Шорты", 120);
    Product product4 = new Product(4, "Носки", 50);
    Product product5 = new Product(5, "Джинсы", 2500);
    Product product6 = new Product(6, "Кепка", 400);
    Product product7 = new Product(7, "Шапка", 450);
    Product product8 = new Product(8, "Лонгслив", 350);
    Product product9 = new Product(9, "Кофта", 1500);
    Product product10 = new Product(10, "Перчатки", 800);
    Product product11 = new Product(11, "Куртка", 3500);

    ShopRepository repo = new ShopRepository();

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
        repo.add(product7);
        repo.add(product8);
        repo.add(product9);
        repo.add(product10);
    }


    @Test
    public void shouldFindById() {

        Product expected = product4;
        Product actual = repo.findById(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFound() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(11);
        });
    }

    @Test
    public void shouldAddProduct() {

        repo.add(product11);

        Product[] expected = { product1, product2, product3, product4, product5, product6, product7, product8, product9, product10, product11 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddProductBecauseExists() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product5);
        });
    }
}
