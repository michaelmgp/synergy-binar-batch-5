package luas_dan_volume;

import implement.PressAnyKeyImpl;
import interfaces.PressAnyKey;

import java.util.Scanner;

public class LuasBidang {

    static Scanner scanner = new Scanner(System.in);
    private static PressAnyKeyImpl pressAnyKey;
    public static void luasPersegiPanjang(){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Persegi Panjang");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Panjang : ");
        double panjang = scanner.nextDouble();
        System.out.println("");
        System.out.print("Masukkan Lebar : ");
        double lebar = scanner.nextDouble();
        System.out.println("");
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        System.out.println("");
        double luasPersegiPanjang= panjang*lebar;
        System.out.println("Luas Persegi Panjang adalah " + luasPersegiPanjang);
        System.out.println("------------------------------------------");

        pressAnyKey.pressAnyKey();
    }
    public static void luasLingkaran(){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Lingkaran");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Jari-jari : ");
        double jariJari = scanner.nextDouble();
        System.out.println("");
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        double luasLingkaran = 3.14*Math.pow(jariJari,2);
        System.out.println("");
        System.out.println("Luas Lingkaran adalah " + luasLingkaran);
        System.out.println("------------------------------------------");

        pressAnyKey.pressAnyKey();
    }

    public static void luasSegitiga(){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Segitiga");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Alas : ");
        double alas = scanner.nextDouble();
        System.out.println("");
        System.out.print("Masukkan Tinggi : ");
        double tinggi = scanner.nextDouble();
        System.out.println("");
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        System.out.println("");
        double luasSegitiga = 0.5*alas*tinggi;
        System.out.println("Luas Segitiga adalah " + luasSegitiga);
        System.out.println("------------------------------------------");

        pressAnyKey.pressAnyKey();

    }
    public static void luasPersegi(){
        System.out.println("------------------------------------------");
        System.out.println("Anda Memilih Persegi");
        System.out.println("------------------------------------------");
        System.out.print("Masukkan Sisi : ");
        double sisi = scanner.nextDouble();
        System.out.println("");
        System.out.print("Processing ");
        for(int i = 0; i<5 ; i++){
            System.out.print(". ");
        }
        System.out.println("");
        double luasPersegi =Math.pow(sisi,2);
        System.out.println("Luas Persegi Panjang adalah " + luasPersegi);
        System.out.println("------------------------------------------");
        pressAnyKey.pressAnyKey();

    }

}
