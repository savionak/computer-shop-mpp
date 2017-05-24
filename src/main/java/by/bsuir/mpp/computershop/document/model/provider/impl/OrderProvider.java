package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.Order;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class OrderProvider implements ContentProvider<Order, Order> {
    @Override
    public String createFilename(Order order) {
        return "order_state";
    }

    @Override
    public String createTitle(Order order) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Order State for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(Order order) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Type", "Model", "Price", "Count");
    }

    @Override
    public String createTableTitle(Order order, Collection<Order> courseFeedbacks) {
        return "Order state";
    }

    @Override
    public List<List<String>> createRows(Collection<Order> orders) {
        return orders.stream()
                .map(orderItem -> Arrays.asList(
                        orderItem.getModel().getType().getName(),
                        orderItem.getModel().getName(),
                        orderItem.getPrice().toString(),
                        orderItem.getCount().toString()))
                .collect(Collectors.toList());
    }
}
