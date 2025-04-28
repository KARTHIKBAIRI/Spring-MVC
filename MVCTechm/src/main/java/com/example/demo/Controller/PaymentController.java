package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Payment;
import com.example.demo.services.PaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	PaymentService service;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping
	public String getallpayments(Model m) {
		List<Payment> li = service.getallpayments();
		m.addAttribute("payments", li);
		return "allpayments";
	}

	@GetMapping("/add")
	public String showaddform(Model m) {
		m.addAttribute("payment", new Payment());
		return "addpayment";

	}

	@PostMapping("/add")
	public String addpayment(@ModelAttribute("payment") Payment p) {
		service.addPayment(p);
		return "redirect:/payments";

	}

	@GetMapping("/delete/{id}")
	public String deletepayment(@PathVariable("id") long id) {
		service.deletebyid(id);
		return "redirect:/payments";
	}
	
	@GetMapping("/update/{id}")
	public String showupdateform(@PathVariable("id") long id, Model m) {
		Payment p=service.getbyid(id);
		m.addAttribute("payment", p);
		return "updatepayment";

	}

	
	@PostMapping("/update/{id}")
	public String updatepayment(@PathVariable("id") long id, @ModelAttribute Payment p) {
		service.updatebyid(p, id);
		return "redirect:/payments";
	}

}
