package by.bsuir.mpp.computershop.entity;


  public  enum ImportStatus
  {
      REGISTERED{
          public String toString() {
              return "зарегистрирован";
          }
      },
      FINISHED{
          public String toString() {
              return "принят";
          }
      };
      public abstract String toString();

  }

