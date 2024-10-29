package ru.agaev.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "Invoice")
public class Invoice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Number of invoice should not be empty")
    @Column(name = "invoice_number")
    private int invoiceNumber;

    @NotEmpty(message = "Total price should not be empty")
    @Column(name = "total_price")
    private double totalPrice;

    @OneToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    public Invoice() {

    }

    public Invoice(int invoiceNumber, double totalPrice, Order order) {
        this.invoiceNumber = invoiceNumber;
        this.totalPrice = totalPrice;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
