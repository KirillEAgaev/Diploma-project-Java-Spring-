package ru.agaev.springcourse.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Order number should not be empty")
    @Column(name = "order_number", unique = true)
    private int orderNumber;

    @Column(name = "date_order")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") //дд/мм/гггг
    private Date dateOfOrder;

    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") //дд/мм/гггг
    private Date dateOfDeparture;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client owner;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager managerId;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status statusId;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    private PaymentMethod paymentMethodId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<MaterialInOrder> materialsInOrder;

    @OneToOne(mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Invoice invoice;

    public Order() {

    }

    public Order(int orderNumber, Date dateOfOrder, Date dateOfDeparture, Client owner, Manager managerId, Status statusId, PaymentMethod paymentMethodId, Invoice invoice) {
        this.orderNumber = orderNumber;
        this.dateOfOrder = dateOfOrder;
        this.dateOfDeparture = dateOfDeparture;
        this.owner = owner;
        this.managerId = managerId;
        this.statusId = statusId;
        this.paymentMethodId = paymentMethodId;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Manager getManagerId() {
        return managerId;
    }

    public void setManagerId(Manager managerId) {
        this.managerId = managerId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<MaterialInOrder> getMaterialsInOrder() {
        return materialsInOrder;
    }

    public void setMaterialsInOrder(List<MaterialInOrder> materialsInOrder) {
        this.materialsInOrder = materialsInOrder;
    }
}
