package ru.agaev.springcourse.models;

import javax.persistence.*;

@Entity
@Table(name = "materials_in_order")
@IdClass(MaterialInOrderId.class)
public class MaterialInOrder {

    @Id
    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material; // Связь с классом Material

    @Id
    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private Order order; // Связь с классом Order

    @Column(name = "amount", nullable = false)
    private int quantity; // Количество товара

    @Column(name = "unit_of_measurement", nullable = false)
    private String unit; // Единица измерения

    @Column(name = "summ", nullable = false)
    private double totalPrice; // Сумма

    @Column(name = "discount", nullable = true)
    private double discount; // Скидка, может быть null

    // Конструктор
    public MaterialInOrder() {}

    public MaterialInOrder(Material material, Order order, int quantity, String unit, double totalPrice, double discount) {
        this.material = material;
        this.order = order;
        this.quantity = quantity;
        this.unit = unit;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

