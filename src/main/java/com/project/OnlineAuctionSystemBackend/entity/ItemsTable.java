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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public UsersTable getUser() {
        return user;
    }

    public void setUser(UsersTable user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoriesTable getCategory() {
        return category;
    }

    public void setCategory(CategoriesTable category) {
        this.category = category;
    }

    public SubCategoriesTable getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoriesTable subCategory) {
        this.subCategory = subCategory;
    }

    public BigDecimal getStartBid() {
        return startBid;
    }

    public void setStartBid(BigDecimal startBid) {
        this.startBid = startBid;
    }

    public LocalDateTime getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(LocalDateTime auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public LocalDateTime getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(LocalDateTime auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }
}
