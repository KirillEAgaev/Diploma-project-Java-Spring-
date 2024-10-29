package ru.agaev.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name of status should not be empty")
    @Size(min = 2, max = 100, message = "Name of status should be between 2 and 100 characters")
    @Column(name = "status_name")
    private String statusName;

    @OneToMany(mappedBy = "statusId")
    private List<Order> statusOrders;

    public Status() {

    }

    public Status(String statusName, List<Order> statusOrders) {
        this.statusName = statusName;
        this.statusOrders = statusOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Order> getStatusOrders() {
        return statusOrders;
    }

    public void setStatusOrders(List<Order> statusOrders) {
        this.statusOrders = statusOrders;
    }
}
