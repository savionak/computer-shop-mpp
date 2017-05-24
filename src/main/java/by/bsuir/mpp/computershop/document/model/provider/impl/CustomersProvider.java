package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.Customer;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class CustomersProvider implements ContentProvider<Customer, Customer> {
    @Override
    public String createFilename(Customer customer) {
        return "customers_list";
    }

    @Override
    public String createTitle(Customer customer) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Customers list for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(Customer customer) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Name", "Orders Count");
    }

    @Override
    public String createTableTitle(Customer customer, Collection<Customer> customers) {
        return "Customers list";
    }

    @Override
    public List<List<String>> createRows(Collection<Customer> customers) {
        return customers.stream()
                .map(customerItem -> Arrays.asList(
                        customerItem.getName(),
                        customerItem.getOrdersCount().toString())
                )
                .collect(Collectors.toList());
    }
}
