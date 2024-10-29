package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.Status;

@Repository
public interface StatusesRepository extends JpaRepository<Status, Integer> {
    Status findByStatusName(String statusName);
}
