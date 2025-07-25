package com.customer.billing.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.billing.prototype.model.BillingAccount;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, Integer> {
}
