package by.bsuir.mpp.computershop.entity;

public enum Status{
        ACTIVE{
            public String toString() {
                return "активен";
            }
        },
        BLOCKED{
            public String toString() {
                return "заблокирован";
            }
        },
        DELETED{
            public String toString() {
                return "удален";
            }
        };
    public abstract String toString();

}
