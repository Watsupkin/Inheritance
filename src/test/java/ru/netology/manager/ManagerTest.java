package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
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
    Smartphone smartphone1 = new Smartphone(4, "GalaxyS6", 25000, "Samsung");


    @BeforeEach
    public void initEach() {
        man.add(book);
        man.add(smartphone);
        man.add(tshort);
        man.add(smartphone1);
    }

    @Test
    void shouldSearchByProducer() {

        Product[] expected = {smartphone};
        Product[] actual = man.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByName() {

        Product[] expected = {book};
        Product[] actual = man.searchBy("Kolobok");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {

        Product[] expected = {book};
        Product[] actual = man.searchBy("ChackPalanik");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchMoreThenOne() {

        Product[] expected = {smartphone, smartphone1};
        Product[] actual = man.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNonexistentName() {

        Product[] expected = {};
        Product[] actual = man.searchBy("IPhone");
        assertArrayEquals(expected, actual);
    }
}