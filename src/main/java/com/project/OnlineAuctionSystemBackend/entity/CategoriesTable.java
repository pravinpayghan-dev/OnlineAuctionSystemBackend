package com.project.OnlineAuctionSystemBackend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Categories")
public class CategoriesTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    @JsonProperty("categoryId")
    private int categoryId;

    @Column(name = "CategoryName")
    @JsonProperty("categoryName")
    private String categoryName;

    // Constructors, getters, setters
    public CategoriesTable() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
