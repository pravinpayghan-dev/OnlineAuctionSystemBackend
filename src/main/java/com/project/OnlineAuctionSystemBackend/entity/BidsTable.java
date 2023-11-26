package com.project.OnlineAuctionSystemBackend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bids")
public class BidsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BidID")
    private int bidId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private UsersTable user;

    @ManyToOne
    @JoinColumn(name = "ItemID")
    private ItemsTable item;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "BidTime")
    private LocalDateTime bidTime;

    // Constructors, getters, setters
    public BidsTable() {
    }
}
