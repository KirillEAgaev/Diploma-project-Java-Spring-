package ru.agaev.springcourse.errors;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Заказ не найден: " + id);
    }
}
