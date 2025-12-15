package se.chasacademy.databaser.jpaorders.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Column(name = "PROD_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "PROD_NAME", nullable = false,length = 150)
    private String name;

    @Column(name = "PROD_DESC",length = 500)
    private String description;

    @Column(name = "UNIT_PRICE_CENTS",nullable = false,columnDefinition = "INT CHECK (UNIT_PRICE_CENTS > 0)")
    private int price_in_cents;

    @Column(name = "ACTIVE_FLAG",nullable = false,columnDefinition = "DEFAULT 'Y'")
    private Character Active_Status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice_in_cents() {
        return price_in_cents;
    }

    public void setPrice_in_cents(int price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    public Character getActive_Status() {
        return Active_Status;
    }

    public void setActive_Status(Character active_Status) {
        Active_Status = active_Status;
    }
}
