package src.models;

public class Passager {
  public static int nextId;
  public int id;
  public double bagWeight;
  public String placeClass;
  public boolean isChild;

  public Passager (double bagWeight, String placeClass, boolean isChild) {
    this.id = Passager.incrementId();

    this.bagWeight = bagWeight;
    this.placeClass = placeClass;
    this.isChild = isChild;
  }
  private static int incrementId () {
    Customer.nextId++;
    return Customer.nextId;
  }
}
