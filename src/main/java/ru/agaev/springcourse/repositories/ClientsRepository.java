package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.Client;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {

}
