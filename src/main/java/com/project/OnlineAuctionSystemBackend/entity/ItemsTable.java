package com.project.OnlineAuctionSystemBackend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "Items")
public class ItemsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private UsersTable user;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private CategoriesTable category;

    @ManyToOne
    @JoinColumn(name = "SubCategoryID")
    private SubCategoriesTable subCategory;

    @Column(name = "StartBid")
    private BigDecimal startBid;

    @Column(name = "AuctionStartTime")
    private LocalDateTime auctionStartTime;

    @Column(name = "AuctionEndTime")
    private LocalDateTime auctionEndTime;

    // Constructors, getters, setters
    public ItemsTable() {
    }
}
