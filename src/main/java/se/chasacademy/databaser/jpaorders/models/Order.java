package se.chasacademy.databaser.jpaorders.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id", nullable = false)
    private Long id;
    @Column(name = "order_number", nullable = false, unique = true, length = 50)
    private String number;
    @Column(name = "order_date", nullable = false)
    private Date orderDate;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "cust_id", nullable = false)
    private Customer customer;
    @Column(name = "status_code", nullable = false, length = 20)
    private String statusCode;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> order_entries = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }

    public List<OrderLine> getOrder_entries() {
        return order_entries;
    }

    public void setOrder_entries(List<OrderLine> order_entries) {
        this.order_entries = order_entries;
    }
}
