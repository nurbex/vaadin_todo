package com.todo.yolo.repositories;

import com.todo.yolo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

    @Transactional
    void deleteByDone(boolean done);
}
