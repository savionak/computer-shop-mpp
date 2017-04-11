package by.bsuir.mpp.computershop.entity;

public enum EmployeeRole {

        RECEIVER{
            public String toString() {
                return "приемщик";
            }
        },
        ASSEMBLER{
            public String toString() {
                return "сборщик";
            }
        }
        ,
        MANAGER{
            public String toString() {
                return "менеджер";
            }
        }
        ,
        DIRECTOR{
            public String toString() {
                return "директор";
            }
        }
        ,
        ADMIN{
            public String toString() {
                return "администратор";
            }
        }
        ;
        public abstract String toString();


}
