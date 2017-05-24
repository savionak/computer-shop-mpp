package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.data.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class UsersProvider implements ContentProvider<UserAuth, UserAuth> {
    @Override
    public String createFilename(UserAuth userAuth) {
        return "users_list";
    }

    @Override
    public String createTitle(UserAuth userAuth) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Users list State for %s", dateFormat.format(new Date()));
    }

    @Override
    public List<Pair<String, String>> createSubtitles(UserAuth userAuth) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Email", "Role", "First Name", "Last Name");
    }

    @Override
    public String createTableTitle(UserAuth userAuth, Collection<UserAuth> users) {
        return "Active users list";
    }

    @Override
    public List<List<String>> createRows(Collection<UserAuth> userAuths) {
        return userAuths.stream()
                .map(userAuthItem -> Arrays.asList(
                        userAuthItem.getEmail(),
                        userAuthItem.getRole().toString(),
                        userAuthItem.getUserInfo().getFirstName(),
                        userAuthItem.getUserInfo().getLastName())
                )
                .collect(Collectors.toList());
    }
}
