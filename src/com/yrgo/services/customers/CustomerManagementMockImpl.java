package com.yrgo.services.customers;

import java.util.*;

import com.yrgo.domain.Call;
import com.yrgo.domain.Customer;

public class CustomerManagementMockImpl implements CustomerManagementService {
	private HashMap<String,Customer> customerMap;

	public CustomerManagementMockImpl() {
		customerMap = new HashMap<String,Customer>();
		customerMap.put("OB74", new Customer("OB74" ,"Fargo Ltd", "some notes"));
		customerMap.put("NV10", new Customer("NV10" ,"North Ltd", "some other notes"));
		customerMap.put("RM210", new Customer("RM210" ,"River Ltd", "some more notes"));
	}


	@Override
	public void newCustomer(Customer newCustomer) {
		this.customerMap.putIfAbsent(newCustomer.getCustomerId(), newCustomer);
	}

	@Override
	public void updateCustomer(Customer changedCustomer) {
		this.customerMap.put(changedCustomer.getCustomerId(), changedCustomer);

	}

	@Override
	public void deleteCustomer(Customer oldCustomer) {
		// TODO Auto-generated method stub
		this.customerMap.remove(oldCustomer.getCustomerId());
	}

	@Override
	public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
		Customer temp = this.customerMap.get(customerId);
		if ((temp.equals(null)))
		{
			throw new  CustomerNotFoundException();
		}
		else
		{
			return temp;
		}
	}

	@Override
	public List<Customer> findCustomersByName(String name) {

		List<Customer> customerArrayList = new ArrayList<>();
		for(Map.Entry<String, Customer>  entry : this.customerMap.entrySet() )
		{
			if(entry.getValue().getCompanyName().equalsIgnoreCase(name))
			{
				customerArrayList.add(entry.getValue());
			}
		}


		return customerArrayList;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return  new ArrayList<>(this.customerMap.values());
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
		Customer customer = this.customerMap.get(customerId);
		if ((customer.equals(null)))
		{
			throw new  CustomerNotFoundException();
		}
		else
		{
			return customer;
		}
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		//First find the customer
			Customer customer = this.customerMap.get(customerId);
		if ((customer.equals(null)))
		{
			throw new  CustomerNotFoundException();
		}
		else
		{
			//Call the addCall on the customer
			customer.addCall(callDetails);
		}
	}

}
