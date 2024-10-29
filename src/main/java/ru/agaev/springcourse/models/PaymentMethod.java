package ru.agaev.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Payment_method")
public class PaymentMethod {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name of payment method should not be empty")
    @Size(min = 2, max = 100, message = "Name of payment method should be between 2 and 100 characters")
    @Column(name = "name_payment_method")
    private String namePaymentMethod;

    @OneToMany(mappedBy = "paymentMethodId")
    private List<Order> paymentMethodOrders;

    public PaymentMethod() {

    }

    public PaymentMethod(String namePaymentMethod, List<Order> paymentMethodOrders) {
        this.namePaymentMethod = namePaymentMethod;
        this.paymentMethodOrders = paymentMethodOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePaymentMethod() {
        return namePaymentMethod;
    }

    public void setNamePaymentMethod(String namePaymentMethod) {
        this.namePaymentMethod = namePaymentMethod;
    }

    public List<Order> getPaymentMethodOrders() {
        return paymentMethodOrders;
    }

    public void setPaymentMethodOrders(List<Order> paymentMethodOrders) {
        this.paymentMethodOrders = paymentMethodOrders;
    }
}
