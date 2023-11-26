package com.project.OnlineAuctionSystemBackend.repository;

import com.project.OnlineAuctionSystemBackend.entity.ItemsTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsTableRepository extends JpaRepository<ItemsTable, Integer> {
}
