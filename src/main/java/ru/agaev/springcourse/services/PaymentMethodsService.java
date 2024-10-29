package ru.agaev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agaev.springcourse.models.PaymentMethod;
import ru.agaev.springcourse.repositories.PaymentMethodsRepository;

import java.util.List;

@Service
public class PaymentMethodsService {

    @Autowired
    private PaymentMethodsRepository paymentMethodsRepository;

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodsRepository.findAll();
    }

    public PaymentMethod getPaymentMethodById(int id) {
        return paymentMethodsRepository.findById(id).orElse(null);
    }

    public PaymentMethod getPaymentMethodByName(String namePaymentMethod) {
        return paymentMethodsRepository.findByNamePaymentMethod(namePaymentMethod);
    }
}
