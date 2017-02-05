package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class BankService {

	private final Map<String, Customer> database = new LinkedHashMap<>();

	public void save(Customer customer) {

		database.put(customer.getId(), customer);
	}

	public Map<String, Customer> getDatabase() {
		return this.database;
	}

	public void delete(String id) {

		database.remove(id);
	}

	public List<Customer> findAllCustomers() {

		return new ArrayList<>(this.database.values());
	}

	public Customer findCustomerByID(String id) {

		return this.database.get(id);
	}

	public List<Customer> findCustomerByName(String word) {

		return this.database.values().stream().filter(customer -> customer.getName().contains(word)).collect(toList());
	}

	public List<Customer> findCustomerNegativeBalance() {

	    return findAllCustomers().stream()
                .map(Customer::getAccount)
                .flatMap(Collection::stream)
                .filter(a -> a.getBalance() < 0)              
                .map(a -> a.getCustomer())
                .collect(toList());

	}

}
