package com.customer.billing.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.billing.prototype.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
