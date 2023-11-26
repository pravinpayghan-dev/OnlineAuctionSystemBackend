package com.project.OnlineAuctionSystemBackend.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "SubCategories")
public class SubCategoriesTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubCategoryID")
    private int subCategoryId;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private CategoriesTable category;

    @Column(name = "SubCategoryName")
    private String subCategoryName;

    // Constructors, getters, setters
    public SubCategoriesTable() {
    }
}

