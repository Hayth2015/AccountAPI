package com.account.api.repository;

import com.account.api.TestUtil;
import com.account.api.constant.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void injectedComponentsAreNotNull(){
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(customerRepository);
    }

    @Test
    void whenSaved_thenFindsById() {
        customerRepository.saveAndFlush(TestUtil.createCustomer());
        Assertions.assertNotNull(customerRepository.findById(UUID.fromString(Constants.Customer.CUSTOMER_UUID)));
    }
}
