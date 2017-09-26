package br.com.app.controller;

import br.com.app.domain.model.Customer;
import br.com.app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/customers")
    public Page<Customer> customers (@PageableDefault @SortDefault final Pageable pageable) {
        return this.service.findAll(pageable);
    }
}
