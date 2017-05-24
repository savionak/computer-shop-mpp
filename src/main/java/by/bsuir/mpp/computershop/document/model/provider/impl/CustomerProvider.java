package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.Customer;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class CustomerProvider implements ContentProvider<Customer, Customer> {
    @Override
    public String createFilename(Customer customer) {
        return "customer_state";
    }

    @Override
    public String createTitle(Customer customer) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Customer State for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(Customer customer) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Type", "Model", "Price", "Count");
    }

    @Override
    public String createTableTitle(Customer customer, Collection<Customer> courseFeedbacks) {
        return "Customer state";
    }

    @Override
    public List<List<String>> createRows(Collection<Customer> customers) {
        return customers.stream()
                .map(customerItem -> Arrays.asList(
                        customerItem.getModel().getType().getName(),
                        customerItem.getModel().getName(),
                        customerItem.getPrice().toString(),
                        customerItem.getCount().toString()))
                .collect(Collectors.toList());
    }
}
