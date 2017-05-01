package by.bsuir.mpp.computershop.dto.brief.pages;

public class PageDto {

    private int totalPages;

    private int number;

    private int size;

    private long totalElements;

    private int numberOfElements;   // <= content.length

    private Iterable content;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Iterable getContent() {
        return content;
    }

    public void setContent(Iterable content) {
        this.content = content;
    }
}
