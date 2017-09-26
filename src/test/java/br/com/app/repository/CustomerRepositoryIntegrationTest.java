package br.com.app.repository;

import br.com.app.domain.model.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {

    @Autowired
    private CustomerRepository subject;

    @Test
    public void findAllShouldReturnResults () {
        final Page<Customer> result = this.subject.findAll(new PageRequest(0, 100));
        Assert.assertEquals(3, result.getNumberOfElements());
    }

    @After
    public void tearDown () throws Exception {
        this.subject.deleteAll();
    }
}