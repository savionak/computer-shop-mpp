package by.bsuir.mpp.computershop.entity;


  public  enum ImportStatus
  {
      REGISTERED{
          public String toString() {
              return "зарегистрирован";
          }
      },
      ADOPTED{
          public String toString() {
              return "принят";
          }
      };
      public abstract String toString();

  }

