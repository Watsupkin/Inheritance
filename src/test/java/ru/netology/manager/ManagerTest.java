package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager man = new Manager();
    Book book = new Book(1, "Kolobok", 100, "ChackPalanik");
    Smartphone smartphone = new Smartphone(2, "GalaxyA6", 20000, "Samsung");
    Product tshort = new Product(3, "TShort", 200);

    @Test
    void shouldSearchBy() {
        man.add(book);
        man.add(smartphone);
        man.add(tshort);
        man.searchBy("Samsung");

        Product[] expected = {smartphone};
        Product[] actual = man.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
}