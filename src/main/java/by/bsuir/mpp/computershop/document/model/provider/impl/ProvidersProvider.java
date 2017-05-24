package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.Provider;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class ProvidersProvider implements ContentProvider<Provider, Provider> {
    @Override
    public String createFilename(Provider provider) {
        return "providers_list";
    }

    @Override
    public String createTitle(Provider provider) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Providers list for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(Provider provider) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Name", "Imports Count");
    }

    @Override
    public String createTableTitle(Provider provider, Collection<Provider> providers) {
        return "Providers list";
    }

    @Override
    public List<List<String>> createRows(Collection<Provider> providers) {
        return providers.stream()
                .map(providerItem -> Arrays.asList(
                        providerItem.getName(),
                        providerItem.getImportsCount().toString())
                )
                .collect(Collectors.toList());
    }
}
