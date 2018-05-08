package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {


    static Person[] people;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int totalCount = 0;
    static int result;

    public static void main(String[] args) {
        System.out.print("Çekilişe Katılacak Kişi Sayısını Giriniz: ");
        int personCount = scanner.nextInt();
        people = new Person[personCount];

        for (int i= 0; i < personCount; i++) {
            people[i] = new Person();
            System.out.print((i +1) + ". Kişi Adını Giriniz: ");
            people[i].Name = scanner.next();
            System.out.print((i + 1) + ". Kişi Çekiliş Hakkı Sayısı Giriniz: ");
            people[i].Count = scanner.nextInt();
            totalCount += people[i].Count;
        }

        System.out.println("Çekilişi başlatmak İçin E/e tuşuna basınız:");
        String start = scanner.next();

        if (start.equals("E") || start.equals("e")) {
            System.out.println("Çekiliş yapılıyor...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {

            }

            result = random.nextInt() % totalCount + 1;
            System.out.println(result);
            for (int i= 0; i < personCount; i++){
                if (result > people[i].Count) {
                    result -= people[i].Count;
                }
                else{
                    System.out.println("Çakilişi Kazanan Kişi: " + people[i].Name);
                    break;
                }
            }
        }


    }
}
