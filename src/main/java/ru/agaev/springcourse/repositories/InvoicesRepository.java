package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.Invoice;

import java.util.List;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByOrderId(int orderId);
}
