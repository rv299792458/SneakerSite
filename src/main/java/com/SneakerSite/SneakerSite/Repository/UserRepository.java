package com.SneakerSite.SneakerSite.Repository;

import com.SneakerSite.SneakerSite.Models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    

    List<UserAccount> findByEmail(String email);

    List<UserAccount> findByUsername(String username);
}
