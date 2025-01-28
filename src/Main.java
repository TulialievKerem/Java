package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.config.Cities;
import src.models.City;
import src.models.Customer;
import src.models.Passager;
import src.utils.AppSystem;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Доступные города:");
    for (City city : Cities.cityList) {
      System.out.println(city.name + " - " + city.id);
    }
    
    System.out.println("Выберите id города взлета:");
    int selectedStartCityId = Integer.parseInt(scanner.nextLine());
    City startCity = Cities.getCityById(selectedStartCityId);
    System.out.println("Город взлета: " + (startCity != null ? startCity.name : "Не найден!"));

    System.out.println("Выберите id города посадки:");
    int selectedFinalCityId = Integer.parseInt(scanner.nextLine());
    City finalCity = Cities.getCityById(selectedFinalCityId);
    System.out.println("Город посадки: " + (finalCity != null ? finalCity.name : "Не найден!"));


    System.out.println("Укажите свое имя:");
    String customerName = scanner.nextLine();
    
    System.out.println("Укажите количество пассажиров:");
    int passagerAmount = Integer.parseInt(scanner.nextLine());

    ArrayList<Passager> passagersList = new ArrayList<>();

    for (int i = 0; i < passagerAmount; i++) {
      System.out.println("Заполните информацию о пассажире "+i+":");

      System.out.println("Есть ли пассажиру 18? Да - 1, нет - 0");
      int isChild = Integer.parseInt(scanner.nextLine());

      System.out.println("Тип места: vip - 1, usual - 0");
      int isVipPlace = Integer.parseInt(scanner.nextLine());

      System.out.println("Вес багажа в кг:");
      double bagWeight = Double.parseDouble(scanner.nextLine());

      Passager newPassager = new Passager(bagWeight, isVipPlace == 1 ? "vip" : "ususal", isChild == 1 ? false : true);
      passagersList.add(newPassager);
    }

    Passager[] passagers = new Passager[passagersList.size()];
    passagers = passagersList.toArray(passagers);

    Customer newCustomer = new Customer(customerName, selectedStartCityId, selectedFinalCityId, passagers);

    AppSystem.sendCustomerInfo(newCustomer);

    scanner.close();
  }
}
