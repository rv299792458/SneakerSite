package com.SneakerSite.SneakerSite.Repository;

import com.SneakerSite.SneakerSite.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    Session findByUsername(String username);

}
