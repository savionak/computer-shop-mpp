package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.Provider;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class ProviderImportsProvider implements ContentProvider<Provider, Import> {
    @Override
    public String createFilename(Provider provider) {
        return "provider_imports";
    }

    @Override
    public String createTitle(Provider provider) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Import State for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(Provider provider) {
        List<Pair<String, String>> subtitles = new ArrayList<>();
        subtitles.add(Pair.of("Provider name", provider.getName()));
        subtitles.add(Pair.of("Imports count", provider.getImportsCount().toString()));
        return subtitles;
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList( "Model", "Purchase Price", "Count");
    }

    @Override
    public String createTableTitle(Provider provider, Collection<Import> imports) {
        return String.format("Imports list of provider %d", provider.getId());
    }

    @Override
    public List<List<String>> createRows(Collection<Import> imports) {
        return imports.stream()
                .map(importItem -> Arrays.asList(
                        importItem.getModel().getName(),
                        importItem.getPurchasePrice().toString(),
                        importItem.getCount().toString()))
                .collect(Collectors.toList());
    }
}
