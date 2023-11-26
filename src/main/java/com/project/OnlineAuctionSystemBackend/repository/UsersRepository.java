package com.project.OnlineAuctionSystemBackend.repository;

import com.project.OnlineAuctionSystemBackend.entity.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<UsersTable, Integer> {
    Optional<UsersTable> findByEmail(String email);
}
