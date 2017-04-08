package by.bsuir.mpp.computershop.entity;

/**
 * Created by Liza on 08.04.2017.
 */
public enum EmployeeRole {

        RECEIVER{
            public String toString() {
                return "приемщик";
            }
        },
        COLLECTOR{
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
        ADMINISTRATOR{
            public String toString() {
                return "администратор";
            }
        }
        ;
        public abstract String toString();


}
