package com.yrgo.client;

import com.yrgo.domain.Customer;
import com.yrgo.services.customers.CustomerManagementService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SimpleClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext cointainer = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService service = cointainer.getBean(CustomerManagementService.class);

        List<Customer> customerList = service.getAllCustomers();
        customerList.forEach(System.out::println);
    }
}
