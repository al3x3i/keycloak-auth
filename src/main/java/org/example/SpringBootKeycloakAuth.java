package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootKeycloakAuth {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKeycloakAuth.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private CustomerDAO customerDAO;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        addCustomers();
    }

    public void addCustomers() {
        Customer techCustomer = new Customer();
        techCustomer.setAddress("123 Tech Avenue, Suite 501");
        techCustomer.setName("Tech Innovators Ltd");
        techCustomer.setServiceRendered("Software Development and Consulting");
        customerDAO.save(techCustomer);

        Customer financeCustomer = new Customer();
        financeCustomer.setAddress("456 Finance Street, Floor 10");
        financeCustomer.setName("Financial Strategies LLC");
        financeCustomer.setServiceRendered("Financial Advisory and Investment Planning");
        customerDAO.save(financeCustomer);

        Customer wellnessCustomer = new Customer();
        wellnessCustomer.setAddress("789 Wellness Boulevard, Building C");
        wellnessCustomer.setName("Health Wellness Inc");
        wellnessCustomer.setServiceRendered("Healthcare Services and Wellness Programs");
        customerDAO.save(wellnessCustomer);
    }
}
