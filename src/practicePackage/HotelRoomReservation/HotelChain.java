package practicePackage.HotelRoomReservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class HotelChain {
    ArrayList<Hotel> hotels = new ArrayList<>();

    public void add(String name, int rating, double costRegularWeekday, double costRegularWeekend, double costRewardWeekday, double costRewardWeekend){
        hotels.add(new Hotel(name, rating, costRegularWeekday, costRegularWeekend, costRewardWeekday, costRewardWeekend));
    }

    public String cheapestHotel(boolean reward, LocalDate from, LocalDate to){
        double minimumCost = Double.MAX_VALUE;
        String hotelName = "";
        int rating = -1;
        for (Hotel h : hotels){
            if (minimumCost > h.getCost(reward, from, to) || (minimumCost == h.getCost(reward, from, to) && rating < h.getRating()) ){
                minimumCost = h.getCost(reward, from, to);
                hotelName = h.getName();
                rating = h.getRating();
            }
        }
        return hotelName;
    }

    static class Hotel{
        int rating;
        double costRegularWeekday;
        double costRegularWeekend;
        double costRewardWeekday;
        double costRewardWeekend;
        String name;
        public Hotel(String name, int rating, double costRegularWeekday, double costRegularWeekend, double costRewardWeekday, double costRewardWeekend){
            this.name = name;
            this.rating = rating;
            this.costRegularWeekday = costRegularWeekday;
            this.costRegularWeekend = costRegularWeekend;
            this.costRewardWeekday = costRewardWeekday;
            this.costRewardWeekend = costRewardWeekend;
        }

        public double getCost(boolean reward, LocalDate from, LocalDate to) {
            int days[] = getDaysBetween(from, to);
            if (reward)
                return days[0]*costRewardWeekday + days[1]*costRewardWeekend;
            else
                return days[0]*costRegularWeekday + days[1]*costRegularWeekend;
        }

        int[] getDaysBetween(LocalDate from, LocalDate to){
            int days = to.getDayOfMonth() - from.getDayOfMonth() + 1;
            int weekdays = (days/7)*5;
            int weekends = (days/7)*2;
            int temp = (days%7) + from.getDayOfWeek().ordinal();
            if(temp >= 7) {
                weekdays += temp - 2 - from.getDayOfWeek().ordinal();
                weekends += 2;
            }
            else if (temp == 6){
                weekdays += temp - 1 - from.getDayOfWeek().ordinal();
                weekends += 1;
            }
            else
                weekdays += temp -from.getDayOfWeek().ordinal();
            return new int[]{weekdays,weekends};
        }

        public String getName() {
            return this.name;
        }

        public int getRating() {
            return this.rating;
        }
    }
}
