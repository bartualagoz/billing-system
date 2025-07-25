package com.customer.billing.prototype.controller;

import com.customer.billing.prototype.model.BillingAccount;
import com.customer.billing.prototype.model.Invoice;
import com.customer.billing.prototype.service.BillingAccountService;
import com.customer.billing.prototype.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final BillingAccountService billingAccountService;

    public InvoiceController(InvoiceService invoiceService, BillingAccountService billingAccountService) {
        this.invoiceService = invoiceService;
        this.billingAccountService = billingAccountService;
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        System.out.println("[CONTROLLER] POST /api/invoice called");
        try {
            BillingAccount account = billingAccountService.getAccountById(invoice.getAccount().getId());
            invoice.setAccount(account);
            Invoice newInvoice = invoiceService.createInvoice(invoice);
            System.out.println("[CONTROLLER] Invoice created: " + newInvoice);
            return ResponseEntity.status(HttpStatus.CREATED).body(newInvoice);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] Create invoice failed: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) {
        System.out.println("[CONTROLLER] GET /api/invoice/" + id + " called");
        try {
            Invoice invoice = invoiceService.getInvoiceById(id);
            System.out.println("[CONTROLLER] Invoice found: " + invoice);
            return ResponseEntity.ok(invoice);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] Invoice not found: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        System.out.println("[CONTROLLER] GET /api/invoice called");
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Integer id, @RequestBody Invoice invoice) {
        System.out.println("[CONTROLLER] PUT /api/invoice/" + id + " called");
        System.out.println("[CONTROLLER] Request body invoice ID: " + invoice.getInvoiceId());

        if (!id.equals(invoice.getInvoiceId())) {
            System.out.println("[ERROR] ID mismatch: path ID = " + id + ", body invoiceId = " + invoice.getInvoiceId());
            return ResponseEntity.badRequest().build();
        }

        try {
            // Check if invoice exists before update
            Invoice existingInvoice = invoiceService.getInvoiceById(id);
            System.out.println("[CONTROLLER] Existing invoice before update: " + existingInvoice);

            // Make sure account is attached correctly
            BillingAccount account = billingAccountService.getAccountById(invoice.getAccount().getId());
            invoice.setAccount(account);

            Invoice updated = invoiceService.updateInvoice(invoice);
            System.out.println("[CONTROLLER] Invoice updated successfully: " + updated);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] Invoice update failed: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceById(@PathVariable Integer id) {
        System.out.println("[CONTROLLER] DELETE /api/invoice/" + id + " called");
        try {
            invoiceService.deleteInvoiceById(id);
            System.out.println("[CONTROLLER] Invoice deleted: " + id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.out.println("[ERROR] Delete failed: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("[CONTROLLER] GET /api/invoice/test called");
        return ResponseEntity.ok("InvoiceController is up");
    }
}
