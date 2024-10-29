package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.Manager;


@Repository
public interface ManagersRepository extends JpaRepository<Manager, Integer> {

}
