package by.bsuir.mpp.computershop.entity;


public enum OrderStatus
    {
        GOING{
            public String toString() {
                return "собирается";
            }
        },
        READY{
            public String toString() {
                return "готов  сборке";
            }
        },
        COMPLETED{
            public String toString() {
                return "завершен";
            }
        },
        CANCELLED{
            public String toString() {
                return "отменен";
            }
        };
        public abstract String toString();

        }

