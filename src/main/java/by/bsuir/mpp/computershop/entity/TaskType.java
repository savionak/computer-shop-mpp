package by.bsuir.mpp.computershop.entity;


public enum TaskType{
        ASSEMBLY{
            public String toString() {
                return "собрать";
            }
        },
        DISASSEMBLY{
            public String toString() {
                return "разобрать";
            }
        };
    public abstract String toString();

    }

