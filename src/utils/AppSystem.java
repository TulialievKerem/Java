/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import src.models.Customer;
import src.models.Passager;
import src.models.Plane;

/**
 * Клас AppSystem описує систему обробки інформації про клієнтів та рейси.
 */
public class AppSystem {
  public static Customer customer;
  private static ArrayList<String> messageList = new ArrayList<>();
  public static Message message;
  private static double flightDistance;
  private static LocalTime flightTime;

   /**
   * Надсилає інформацію про клієнта.
   * @param customer Об'єкт клієнта, що містить всю необхідну інформацію.
   */
  public static void sendCustomerInfo (Customer customer) {
    AppSystem.customer = customer;
    AppSystem.message = new Message(customer);
    AppSystem.flightDistance = AppSystem.calculateFlightDistance();
    AppSystem.flightTime = AppSystem.calculateFlightTime();

    double totalPrice = AppSystem.calculateFinalPrice();

    messageList.add("Конечная цена за билет: "+totalPrice+" грн.");

    String[] messages = new String[messageList.size()];
    messages = messageList.toArray(messages);
    message.sendMessage(messages);
  }

  /**
   * Обчислює дистанцію польоту.
   * @return Дистанція польоту в кілометрах.
   */
  public static double calculateFlightDistance () {
    int flightLongX = customer.finalCity.coordinateX - customer.startCity.coordinateX;
    int flightLongY = customer.finalCity.coordinateY - customer.startCity.coordinateY;
    double flightLong = Math.sqrt(Math.pow(flightLongX, 2) + Math.pow(flightLongY, 2));
    return Math.round(flightLong * 10.0) / 10.0;
  }

   /**
   * Обчислює час польоту.
   * @return Час польоту у форматі LocalTime.
   */
  public static LocalTime calculateFlightTime () {
    double minutes = AppSystem.calculateFlightDistance() * 1.5;
    int hours = (int) (minutes / 60);
    int remainingMinutes = (int) (minutes % 60);
    int seconds = (int) ((minutes - (hours * 60 + remainingMinutes)) * 60);
    
    LocalTime time = LocalTime.of(hours, remainingMinutes, seconds);
    return time;
  }

   /**
   * Перевіряє інформацію про літак та наявність місць.
   * @return HashMap з інформацією про кількість звичайних і VIP місць та кількість дітей.
   */
  private static HashMap<String, Object> checkPlaneInfo () {
    HashMap<String, Object> result = new HashMap<>();

    Plane plane = new Plane("Mria MDV_9103", customer.startCity.id, customer.finalCity.id);
    System.out.println("Информация о самолете: ");

    System.out.println("Ваш самолет - "+plane.name);
    System.out.println("Всего обычных мест "+plane.maxPlaces+", из них занятых "+plane.occupedPlacesAmount);
    System.out.println("Всего VIP мест "+plane.maxVipPlaces+", из них занятых "+plane.occupedVipPlacesAmount);
    System.out.println("Время отправки "+plane.departureTime);
    System.out.println("Длинна пути: "+AppSystem.flightDistance+" км.");
    System.out.println("Длительность полета: "+AppSystem.flightTime);


        int occupingPlaceAmount = 0;
        int occupingVipPlaceAmount = 0;
        int childrenAmount = 0;
        
        for (Passager passager : customer.passagers) {
          if(passager.placeClass == "usual") {
            occupingPlaceAmount++;
          } else if (passager.placeClass == "vip") {
            occupingVipPlaceAmount++;
          }
          if(passager.isChild) {
            childrenAmount++;
          }
        }
        int amountFreePlacesResult = plane.maxPlaces - plane.occupedPlacesAmount;
        int amountFreeVipPlacesResult = plane.maxVipPlaces - plane.occupedVipPlacesAmount;

        if(amountFreePlacesResult < occupingPlaceAmount) {
          AppSystem.messageList.add("Не хватило "+ amountFreePlacesResult +" мест в среднем классе. Перераспределение вами мест может помочь");
          
        }
        if(amountFreeVipPlacesResult < occupingVipPlaceAmount) {
          AppSystem.messageList.add("Не хватило "+ amountFreeVipPlacesResult +" мест в VIP классе. Перераспределение вами мест может помочь");
        }
        result.put("occupingPlaceAmount", occupingPlaceAmount);
        result.put("occupingVipPlaceAmount", occupingVipPlaceAmount);
        result.put("childrenAmount", childrenAmount);

      return result;
    }

  /**
   * Обчислює кінцеву вартість польоту.
   * @return Кінцева вартість польоту.
   */
  public static double calculateFinalPrice () {
    HashMap<String, Object> info = AppSystem.checkPlaneInfo();
    double totalPrice = 0;

    double placesConst = (int) info.get("occupingPlaceAmount") * 5500;
    double vipPlacesCost = (int) info.get("occupingVipPlaceAmount") * 9500;
    double childrenMarkupCost = (int) info.get("childrenAmount") * 1750;
    double flightDistanceCost = AppSystem.flightDistance * 20;

    totalPrice = placesConst + vipPlacesCost + childrenMarkupCost + flightDistanceCost;
    return Math.round(totalPrice * 10.0) / 10.0;
  }
}
