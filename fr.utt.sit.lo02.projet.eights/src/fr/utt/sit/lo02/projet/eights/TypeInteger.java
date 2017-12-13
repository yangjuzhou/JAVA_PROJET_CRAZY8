package fr.utt.sit.lo02.projet.eights;

import java.util.Scanner;

public class TypeInteger {
    public int typeInteger() {
        int s=0;
        Scanner sc = new Scanner(System.in);
        boolean ready = true;
        do {
            try {
                s=sc.nextInt();
                ready = true;
            }catch(Exception e) {
                System.out.print("Please enter an integer number:");
                ready = false;
                sc.nextLine();
            }
        }while(ready==false);
        return s;
    }
}
