package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    Order findByOrderNumber(int orderNumber);
}
