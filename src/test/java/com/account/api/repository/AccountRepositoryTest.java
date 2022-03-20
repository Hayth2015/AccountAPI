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
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void injectedComponentsAreNotNull(){
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(accountRepository);
    }

    @Test
    void whenSaved_thenFindsById() {
        accountRepository.save(TestUtil.createAccount());
        Assertions.assertNotNull(accountRepository.findById(UUID.fromString(Constants.Account.ACCOUNT_UUID)));
    }
}
