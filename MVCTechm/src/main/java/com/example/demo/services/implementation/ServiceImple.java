package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.Paymentrepo;
import com.example.demo.models.Payment;
import com.example.demo.services.PaymentService;
@Service
public class ServiceImple implements PaymentService {

	@Autowired
	Paymentrepo repo;
	
	@Override
	public Payment addPayment(Payment p) {
		return repo.save(p);
	}

	@Override
	public List<Payment> getallpayments() {
		return repo.findAll();
	}

	@Override
	public Payment getbyid(long id) {
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("payment not found with this record"+id));
	}

	@Override
	public String deletebyid(long id) {
		repo.deleteById(id);
		return "successfully deleted";
	}

	@Override
	public Payment updatebyid(Payment pay, long id) {
		Payment p = getbyid(id);
		p.setPaymethod(pay.getPaymethod());
		p.setPayaddress(pay.getPayaddress());
		p.setPaypin(pay.getPaypin());
		p.setStatus(pay.isStatus());
		return repo.save(p);
	}

}
