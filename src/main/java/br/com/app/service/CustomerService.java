package br.com.app.service;

import br.com.app.domain.model.Customer;
import br.com.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Page<Customer> findAll (final Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
