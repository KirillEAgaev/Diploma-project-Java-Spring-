package ru.agaev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agaev.springcourse.models.Client;
import ru.agaev.springcourse.models.Invoice;
import ru.agaev.springcourse.models.Manager;
import ru.agaev.springcourse.models.Order;
import ru.agaev.springcourse.repositories.InvoicesRepository;
import ru.agaev.springcourse.repositories.ManagersRepository;

import java.util.Date;
import java.util.List;

@Service
public class ManagersService {

    @Autowired
    private ManagersRepository managersRepository;

    @Autowired
    private InvoicesRepository invoicesRepository;

    public List<Manager> findAll() {
        return managersRepository.findAll();
    }

    // Создание заказа и расчет стоимости
//    public Order createOrder(Client client, double materialWeight, double materialDensity) {
//        Order order = new Order();
//        order.setOrderNumber(generateUniqueOrderNumber());
//        order.setOwner(client);
//        order.setDateOfOrder(new Date());
//
//        double volume = calculateVolume(materialWeight, materialDensity);
//        //order.setVolume(volume);
//
//        double length = calculateRodLength(volume);
//        //order.setLength(length);
//
//        double pricePerKg = 100; // условная цена за кг
//        double totalCost = materialWeight * pricePerKg;
//
//        Invoice invoice = createInvoice(order, totalCost);
//        order.setInvoice(invoice);
//
//        //return managersRepository.save(order);
//    }

    private int generateUniqueOrderNumber() {
        return Integer.parseInt(String.valueOf(System.currentTimeMillis()));
    }

    private double calculateVolume(double weight, double density) {
        return weight / density; // Объем в м³
    }

    private double calculateRodLength(double volume) {
        double diameter = 0.05; // диаметр в метрах
        return volume / (Math.PI * Math.pow(diameter / 2, 2)); // Длина прутка
    }

    private Invoice createInvoice(Order order, double totalCost) {
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setTotalPrice(totalCost);
        return invoicesRepository.save(invoice);
    }

}
