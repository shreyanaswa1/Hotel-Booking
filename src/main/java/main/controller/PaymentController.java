package main.controller;

import main.request.PaymentRequest;
import main.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    public PaymentService paymentService;

    @GetMapping("/all")
    public List<PaymentRequest> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentRequest findById(@PathVariable("id") int id)
    {
        return paymentService.findbyId(id);
    }

    @GetMapping("/{id}/reservation")
    public PaymentRequest findbyId(@PathVariable("id") int id)
    {
        return paymentService.findDetails(id);
    }

    @PostMapping
    public String create(PaymentRequest paymentRequest){
        return paymentService.create(paymentRequest);
    }

}
