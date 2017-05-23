package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class ComponentStoreProvider implements ContentProvider<ComponentStore, ComponentStore> {
    @Override
    public String createFilename(ComponentStore store) {
        return "store_state";
    }

    @Override
    public String createTitle(ComponentStore store) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Component Store State for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(ComponentStore store) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Type", "Model", "Price", "Count");
    }

    @Override
    public String createTableTitle(ComponentStore store, Collection<ComponentStore> courseFeedbacks) {
        return "Component store state";
    }

    @Override
    public List<List<String>> createRows(Collection<ComponentStore> stores) {
        return stores.stream()
                .map(storeItem -> Arrays.asList(
                        storeItem.getModel().getType().getName(),
                        storeItem.getModel().getName(),
                        storeItem.getPrice().toString(),
                        storeItem.getCount().toString()))
                .collect(Collectors.toList());
    }
}
