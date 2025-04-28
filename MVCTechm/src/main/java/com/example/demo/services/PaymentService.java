package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Payment;

public interface PaymentService {
	public Payment addPayment(Payment p);

	public List<Payment> getallpayments();

	public Payment getbyid(long id);

	public String deletebyid(long id);

	public Payment updatebyid(Payment p, long id);
}
