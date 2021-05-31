package com.todo.yolo.repositories;

import com.todo.yolo.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findAuthorityByAuthority(String authority);
}
