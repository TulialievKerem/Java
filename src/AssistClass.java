package src;

public abstract class AssistClass implements Cloneable{
    // Метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        try {
            Class<?> clazz = this.getClass();
            for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object value1 = field.get(this);
                Object value2 = field.get(obj);
                if (value1 == null ? value2 != null : !value1.equals(value2)) {
                    return false;
                }
            }
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
      }
    // Метод hashCode
    @Override
    public int hashCode() {
      int result = 1;
      Class<?> clazz = this.getClass();
      
      try {
          for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
              field.setAccessible(true);
              Object value = field.get(this);
              result = 31 * result + (value != null ? value.hashCode() : 0);
          }
      } catch (IllegalAccessException e) {
          e.printStackTrace();
      }
      
      return result;
    }
}