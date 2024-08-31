package com.Hospital.Management.System.Model;

import jakarta.persistence.*;

@Entity
@Table(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name="drug_name")
    private String drug_name;
    private String stock;

    public Medicine(long id, String drug_name, String stock) {
        this.id = id;
        this.drug_name = drug_name;
        this.stock = stock;
    }

    public Medicine(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
