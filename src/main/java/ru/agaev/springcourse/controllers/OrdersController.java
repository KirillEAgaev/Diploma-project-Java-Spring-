package ru.agaev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.agaev.springcourse.models.Client;
import ru.agaev.springcourse.models.Order;
import ru.agaev.springcourse.services.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;
    private final ClientsService clientsService;

    public OrdersController(OrdersService ordersService, ClientsService clientsService) {
        this.ordersService = ordersService;
        this.clientsService = clientsService;
    }

    @GetMapping
    public String index(Model model) {
        List<Order> orders = ordersService.findAll();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

    @GetMapping("/new")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orders/new";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        Order createdOrder = ordersService.createOrder(order);
        redirectAttributes.addFlashAttribute("message", "Заказ успешно создан с номером: " + createdOrder.getOrderNumber());
        return "redirect:/orders";
    }

    @GetMapping("/{id}")
    public String showOrder(@PathVariable Long id, Model model) {
        Order order = ordersService.findById(id);
        model.addAttribute("order", order);
        return "orders/show";
    }

    @GetMapping("/{id}/edit")
    public String editOrderForm(@PathVariable Long id, Model model) {
        Order order = ordersService.findById(id);
        model.addAttribute("order", order);
        return "orders/edit";
    }

    @PostMapping("/{id}")
    public String editOrder(@PathVariable Long id, @ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        Order updatedOrder = ordersService.updateOrder(id, order);
        if (updatedOrder != null) {
            redirectAttributes.addFlashAttribute("message", "Заказ успешно обновлён с номером: " + updatedOrder.getOrderNumber());
        } else {
            redirectAttributes.addFlashAttribute("error", "Не удалось обновить заказ с ID: " + id);
        }
        return "redirect:/orders";
    }

    @PostMapping("/{id}/delete")
    public String deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/search")
    public String findByOrderNumberForm(Model model) {
        model.addAttribute("orderNumber", 0);
        return "orders/search";
    }

    @PostMapping("/search")
    public String findByOrderNumber(@ModelAttribute int orderNumber, Model model) {
        Order order = ordersService.findByOrderNumber(orderNumber);
        model.addAttribute("order", order);
        return order != null ? "orders/show" : "orders/not_found";
    }

    @GetMapping("/orders/{id}/edit")
    public String editOrderForm(@PathVariable int id, Model model) {
        Order order = ordersService.findOne((long) id);
        List<Client> clients = clientsService.findAll();

        model.addAttribute("order", order);
        model.addAttribute("clients", clients);

        return "orders/edit";
    }

    @GetMapping("/orders/new")
    public String newOrderForm(Model model) {
        List<Client> clients = clientsService.findAll();
        model.addAttribute("clients", clients);
        return "orders/new";
    }
}
