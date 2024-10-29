package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.PaymentMethod;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethod, Integer> {
    PaymentMethod findByNamePaymentMethod(String namePaymentMethod);
}
