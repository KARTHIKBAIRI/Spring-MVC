package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Payment;

@Repository
public interface Paymentrepo extends JpaRepository<Payment, Long>{

}
