package com.todo.yolo.repositories;

import com.todo.yolo.domain.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUserRepository extends JpaRepository<TodoUser,Long> {
    TodoUser findUserByUsername(String username);
}
