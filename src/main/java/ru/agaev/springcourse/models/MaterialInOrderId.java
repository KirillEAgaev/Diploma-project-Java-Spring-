package ru.agaev.springcourse.models;

import java.io.Serializable;
import java.util.Objects;

public class MaterialInOrderId implements Serializable {
    private Long material;
    private Long order;

    public MaterialInOrderId() {}

    public MaterialInOrderId(Long material, Long order) {
        this.material = material;
        this.order = order;
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaterialInOrderId)) return false;
        MaterialInOrderId that = (MaterialInOrderId) o;
        return Objects.equals(material, that.material) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, order);
    }
}
