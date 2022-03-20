package com.account.api;

import com.account.api.component.ExternalizedConfiguration;
import com.account.api.constant.Constants;
import com.account.api.model.Customer;
import com.account.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Main Spring-boot application class that
 * pre-configures and starts the Spring Boot application: Account API.
 */
@SpringBootApplication
public class AccountApiApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public AccountApiApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApiApplication.class, args);
    }

    @Override
    public void run(String... args)  {
        Customer customer = customerRepository.save(new Customer(Constants.Customer.CUSTOMER_NAME_JOHN, Constants.Customer.CUSTOMER_SURNAME_DOE));
        Customer customer2 = customerRepository.save(new Customer(Constants.Customer.CUSTOMER_NAME_JANE, Constants.Customer.CUSTOMER_SURNAME_DOE));

        System.out.println("Created customer " + customer.getName() + " " + customer.getSurname() + " with Id: " + customer.getId());
        System.out.println("Created customer " + customer2.getName() + " " + customer2.getSurname() + " with Id: " + customer2.getId());
    }
}
