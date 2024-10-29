package ru.agaev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agaev.springcourse.models.Order;
import ru.agaev.springcourse.repositories.OrdersRepository;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Order> findAll() {
        return ordersRepository.findAll();
    }

    public Order findById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Order findByOrderNumber(int orderNumber) {
        return ordersRepository.findByOrderNumber(orderNumber);
    }

    public Order createOrder(Order order) {
        return ordersRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = findById(id);
        if (order != null) {
            order.setOrderNumber(orderDetails.getOrderNumber());
            order.setDateOfOrder(orderDetails.getDateOfOrder());
            order.setDateOfDeparture(orderDetails.getDateOfDeparture());
            order.setOwner(orderDetails.getOwner());
            order.setManagerId(orderDetails.getManagerId());
            order.setStatusId(orderDetails.getStatusId());
            order.setPaymentMethodId(orderDetails.getPaymentMethodId());
            order.setMaterialsInOrder(orderDetails.getMaterialsInOrder());
            order.setInvoice(orderDetails.getInvoice());
            return ordersRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }

    public Order findOne(Long id) {
        return findById(id);
    }
}
