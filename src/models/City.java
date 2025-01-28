package src.models;

public class City {
  public static int nextId;
  public int id = 1;
  public String name;
  public int coordinateX;
  public int coordinateY;

  public City (String name, int coordinateX, int coordinateY) {
    this.id = City.incrementId();
    this.name = name;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
    City.incrementId();
  }
  private static int incrementId () {
    City.nextId++;
    return City.nextId;
  }
}
