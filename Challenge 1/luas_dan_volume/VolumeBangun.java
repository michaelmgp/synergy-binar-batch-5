package luas_dan_volume;

import implement.PressAnyKeyImpl;
import interfaces.PressAnyKey;

import java.util.Scanner;

public class VolumeBangun {
    static Scanner scanner = new Scanner(System.in);

    public static void volumeKubus (){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Kubus");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Salah satu Sisi : ");
        double sisi = scanner.nextDouble();
        System.out.println("");
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        System.out.println("");
        double volumeKubus = Math.pow(sisi,3);
        System.out.println("Volume Kubus adalah " + volumeKubus);
        System.out.println("------------------------------------------");

    }

    public static void volumeBalok(){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Balok");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Panjang : ");
        double panjang = scanner.nextDouble();
        System.out.print("Masukkan Lebar : ");
        double lebar = scanner.nextDouble();
        System.out.print("Masukkan Tinggi : ");
        double tinggi = scanner.nextDouble();
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        System.out.println("");
        double volumeBalok= panjang*lebar*tinggi;
        System.out.println("Volume Balok adalah " + volumeBalok);
        System.out.println("------------------------------------------");


    }

    public static void volumeTabung(){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Tabung");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Jari-jarI : ");
        double jariJari = scanner.nextDouble();
        System.out.print("Masukkan Tinggi : ");
        double tinggi = scanner.nextDouble();
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        System.out.println("");
        double volumeTabung= 3.14*jariJari*tinggi;
        System.out.println("Volume Tabung adalah " + volumeTabung);
        System.out.println("------------------------------------------");


    }


}
