package se.chasacademy.databaser.jpaorders.models;

import jakarta.persistence.*;

@Entity
@Table(name = "T_ORDER_LINE")
public class OrderLine {

    @Column(name = "ORDER_LINE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "LINE_NUMBER",nullable = false)
    private int line_number;
    @Column(name = "QTY",nullable = false,columnDefinition = "INT CHECK(QTY>0)")
    private int quantity;
    @Column(name = "LINE_TOTAL_CENTS",nullable = false,columnDefinition = "INT CHECK(QTY>0)")
    private int total_Price_Cents;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID",nullable = false)
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLine_number() {
        return line_number;
    }

    public void setLine_number(int line_number) {
        this.line_number = line_number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal_Price_Cents() {
        return total_Price_Cents;
    }

    public void setTotal_Price_Cents(int total_Price_Cents) {
        this.total_Price_Cents = total_Price_Cents;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", line_number=" + line_number +
                ", quantity=" + quantity +
                ", total_Price_Cents=" + total_Price_Cents +
                ", product=" + product +
                '}';
    }
}

