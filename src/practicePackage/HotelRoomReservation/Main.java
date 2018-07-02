package practicePackage.HotelRoomReservation;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        HotelChain hotelChain = new HotelChain();
        hotelChain.add("Lakewood", 3, 110,90,80,80);
        hotelChain.add("Bridgewood",4,160,60,110,50);
        hotelChain.add("Ridgewood",5,220,150,100,40);

        String s;

        s = hotelChain.cheapestHotel(false, LocalDate.of(2009,3,16), LocalDate.of(2009,3,18));
        System.out.println(s);

        s = hotelChain.cheapestHotel(false, LocalDate.of(2009,3,20), LocalDate.of(2009,3,22));
        System.out.println(s);

        s = hotelChain.cheapestHotel(true, LocalDate.of(2009,3,26), LocalDate.of(2009,3,28));
        System.out.println(s);
    }
}
