package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class UserProvider implements ContentProvider<UserAuth, UserAuth> {
    @Override
    public String createFilename(UserAuth userAuth) {
        return "user_auth_state";
    }

    @Override
    public String createTitle(UserAuth userAuth) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("User Auth State for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(UserAuth userAuth) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Type", "Model", "Price", "Count");
    }

    @Override
    public String createTableTitle(UserAuth userAuth, Collection<UserAuth> courseFeedbacks) {
        return "Component store state";
    }

    @Override
    public List<List<String>> createRows(Collection<UserAuth> userAuths) {
        return userAuths.stream()
                .map(userAuthItem -> Arrays.asList(
                        userAuthItem.getModel().getType().getName(),
                        userAuthItem.getModel().getName(),
                        userAuthItem.getPrice().toString(),
                        userAuthItem.getCount().toString()))
                .collect(Collectors.toList());
    }
}
