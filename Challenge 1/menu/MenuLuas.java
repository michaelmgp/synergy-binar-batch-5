package menu;

import implement.PressAnyKeyImpl;
import interfaces.PressAnyKey;

import java.util.Scanner;

import static luas_dan_volume.LuasBidang.*;

public class MenuLuas {
    static Scanner  scanner = new Scanner(System.in);
    private static PressAnyKey pressAnyKey = new PressAnyKeyImpl();
    public static void menuLuas(){
        System.out.println("------------------------------------------");
        System.out.println("Pilih bidang yang akan dihitung");
        System.out.println("------------------------------------------");
        System.out.println("1. persegi "+"\n"
                +"2. lingkaran "+"\n"
                +"3. segitiga " +"\n"
                +"4. persegi panjang "+"\n"
                +"0. kembali ke menu sebelumnya");
        System.out.println("------------------------------------------");
        System.out.print("Pilihan anda ?");
        int pilihan = scanner.nextInt();
        switch (pilihan){
            case 4:
                luasPersegiPanjang();
                pressAnyKey.pressAnyKey();
                break;
            case 2:
                luasLingkaran();
                pressAnyKey.pressAnyKey();
                break;
            case 3:
                luasSegitiga();
                pressAnyKey.pressAnyKey();
                break;
            case 1:
                luasPersegi();
                pressAnyKey.pressAnyKey();
                break;
            case 0:
                break;
        }



    }

}
