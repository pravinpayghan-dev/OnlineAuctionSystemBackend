package com.project.OnlineAuctionSystemBackend.repository;

import com.project.OnlineAuctionSystemBackend.entity.SubCategoriesTable;
import com.project.OnlineAuctionSystemBackend.entity.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoriesTableRepository extends JpaRepository<SubCategoriesTable, Integer> {
    List<SubCategoriesTable> findByCategory_CategoryId(Integer categoryId);

}
