package com.project.OnlineAuctionSystemBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoriesTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int categoryId;

    @Column(name = "CategoryName")
    private String categoryName;

    // Constructors, getters, setters
    public CategoriesTable() {
    }
}
