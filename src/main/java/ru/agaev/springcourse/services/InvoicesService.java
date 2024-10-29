package ru.agaev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agaev.springcourse.models.Invoice;
import ru.agaev.springcourse.repositories.InvoicesRepository;

import java.util.List;

@Service
public class InvoicesService {

    @Autowired
    private InvoicesRepository invoicesRepository;

    public List<Invoice> getInvoicesByOrderId(int orderId) {
        return invoicesRepository.findByOrderId(orderId);
    }

    public void saveInvoice(Invoice invoice) {
        invoicesRepository.save(invoice);
    }
}
