package by.bsuir.mpp.computershop.document.model.provider.impl;

import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.Import;
//import by.bsuir.mpp.computershop.entity.CourseFeedback;
import org.springframework.data.util.Pair;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.xmlbeans.XmlBeans.getTitle;

public class ImportContentProvider implements ContentProvider<Import, Import> {
    @Override
    public String createFilename(Import import) {
        return String.format("%s_feedbacks", import.getTitle());
    }

    @Override
    public String createTitle(Import import) {
        return import.getTitle();
    }

    @Override
    public List<Pair<String, String>> createSubtitles(Import import) {
        return Collections.singletonList(
                Pair.of("Description", course.getDescription())
        );
    }

    @Override
    public List<String> getHeaders() {
        return Arrays.asList("Student", "Heading", "Feedback");
    }

    @Override
    public String createTableTitle(Import import, Collection<CourseFeedback> courseFeedbacks) {
        return "Feedbacks";
    }

    @Override
    public List<List<String>> createRows(Collection<CourseFeedback> courseFeedbacks) {
        return courseFeedbacks.stream()
                .map(courseFeedback -> Arrays.asList(
                        courseFeedback.getStudent().getFullName(),
                        courseFeedback.getHeading(),
                        formatFeedbackBody(courseFeedback)))
                .collect(Collectors.toList());
    }

    private String formatFeedbackBody(CourseFeedback courseFeedback) {
        return String.format("%s\nPros: %s\nCons: %s",
                courseFeedback.getReport(),
                courseFeedback.getPros(),
                courseFeedback.getCons());
    }
}
