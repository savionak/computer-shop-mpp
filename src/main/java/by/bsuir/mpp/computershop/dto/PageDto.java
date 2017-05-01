package by.bsuir.mpp.computershop.dto;

public class PageDto {

    private Iterable content;

    private PageInfo info;

    public Iterable getContent() {
        return content;
    }

    public void setContent(Iterable content) {
        this.content = content;
    }

    public PageInfo getInfo() {
        return info;
    }

    public void setInfo(PageInfo info) {
        this.info = info;
    }

    public static class PageInfo {

        private int totalPages;

        private int number;

        private boolean isFirst;

        private boolean isLast;

        private boolean hasNext;

        private boolean hasPrevious;

        private int size;

        private long totalElements;

        private int numberOfElements;   // <= content.length

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

        public boolean isFirst() {
            return isFirst;
        }

        public void setFirst(boolean first) {
            isFirst = first;
        }

        public boolean isLast() {
            return isLast;
        }

        public void setLast(boolean last) {
            isLast = last;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public boolean isHasPrevious() {
            return hasPrevious;
        }

        public void setHasPrevious(boolean hasPrevious) {
            this.hasPrevious = hasPrevious;
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
    }
}
