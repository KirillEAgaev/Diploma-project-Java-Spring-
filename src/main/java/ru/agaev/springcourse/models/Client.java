package ru.agaev.springcourse.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name of organization should be between 2 and 100 characters")
    @Column(name = "organization_name")
    private String organizationName;

    @NotEmpty(message = "INN should not be empty")
    @Column(name = "inn")
    private String inn;

    //Город, Улица, Индекс (6 цифр)
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: City, Street, Postal Code (6 digits)")
    @Column(name = "address")
    private String address;

    @NotEmpty(message = "Email should not be empty")
    @Column(name = "email")
    @Email
    private String email;

    @NotEmpty(message = "Phone number should not be empty")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "owner")
    private List<Order> orders;

    public Client() {

    }

    public Client(String organizationName, String inn, String address, String email, String phoneNumber) {
        this.organizationName = organizationName;
        this.inn = inn;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
