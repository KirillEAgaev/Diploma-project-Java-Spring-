package ru.agaev.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Manager")
public class Manager {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name of manager should be between 2 and 100 characters")
    @Column(name = "name")
    private String managerName;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 100, message = "Surname of manager should be between 2 and 100 characters")
    @Column(name = "surname")
    private String managerSurname;

    @NotEmpty(message = "Post should not be empty")
    @Size(min = 2, max = 100, message = "Post of manager should be between 2 and 100 characters")
    @Column(name = "post")
    private String managerPost;

    @NotEmpty(message = "Phone number should not be empty")
    @Column(name = "phone_number")
    private String managerPhoneNumber;

    @OneToMany(mappedBy = "managerId")
    private List<Order> managerOrders;

    public Manager() {

    }

    public Manager(String managerName, String managerSurname, String managerPost, String managerPhoneNumber, List<Order> managerOrders) {
        this.managerName = managerName;
        this.managerSurname = managerSurname;
        this.managerPost = managerPost;
        this.managerPhoneNumber = managerPhoneNumber;
        this.managerOrders = managerOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerSurname() {
        return managerSurname;
    }

    public void setManagerSurname(String managerSurname) {
        this.managerSurname = managerSurname;
    }

    public String getManagerPost() {
        return managerPost;
    }

    public void setManagerPost(String managerPost) {
        this.managerPost = managerPost;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public List<Order> getManagerOrders() {
        return managerOrders;
    }

    public void setManagerOrders(List<Order> managerOrders) {
        this.managerOrders = managerOrders;
    }
}
