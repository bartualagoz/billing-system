package com.customer.billing.prototype.service;

import com.customer.billing.prototype.model.BillingAccount;
import com.customer.billing.prototype.model.Invoice;
import com.customer.billing.prototype.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final BillingAccountService billingAccountService;

    public InvoiceService(InvoiceRepository invoiceRepository, BillingAccountService billingAccountService) {
        this.invoiceRepository = invoiceRepository;
        this.billingAccountService = billingAccountService;
    }

    public Invoice createInvoice(Invoice invoice) {
        if (invoice.getInvoiceId() != null && invoiceRepository.existsById(invoice.getInvoiceId())) {
            throw new RuntimeException("This invoice already exists!");
        }
        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Integer id) {
        Optional<Invoice> optInvoice = invoiceRepository.findById(id);
        if (!optInvoice.isPresent()) {
            System.out.println("[DEBUG] Invoice NOT found with id: " + id);
            throw new RuntimeException("Invoice doesn't exist!");
        }
        System.out.println("[DEBUG] Invoice found: " + optInvoice.get());
        return optInvoice.get();
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice updateInvoice(Invoice invoice) {
        Integer id = invoice.getInvoiceId();
        if (id == null || !invoiceRepository.existsById(id)) {
            throw new RuntimeException("Invoice doesn't exist!");
        }

        System.out.println("[DEBUG] Trying to update invoice with ID: " + id);

        Integer accountId = invoice.getAccount() != null ? invoice.getAccount().getId() : null;
        if (accountId == null) {
            throw new RuntimeException("Invoice must have an account!");
        }

        BillingAccount attachedAccount = billingAccountService.getAccountById(accountId);
        invoice.setAccount(attachedAccount);

        return invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Integer id) {
        if (!invoiceRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete: Invoice not found!");
        }
        invoiceRepository.deleteById(id);
    }
}
