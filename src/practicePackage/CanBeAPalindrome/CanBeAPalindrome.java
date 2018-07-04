package practicePackage.CanBeAPalindrome;

import java.util.ArrayList;
import java.util.Scanner;

public class CanBeAPalindrome {
    public static void main(String [] args){
        String string = (new Scanner(System.in)).next();
        System.out.println("Can String " + string + " be a palindrome ?\n" + canBeAPalindrome(string));
    }
    public static boolean canBeAPalindrome(String string){
        int flag = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++){
            list.add(string.charAt(i));
        }
        list.sort(Character::compareTo);

        for (int i = 0; i < list.size() - 1 ; i += 2){
            if (list.get(i).compareTo(list.get(i+1)) != 0){
                if (flag == 1){
                    flag++;
                    break;
                }
                flag++;
                i--;
            }
        }
        return flag < 2;
    }
}
