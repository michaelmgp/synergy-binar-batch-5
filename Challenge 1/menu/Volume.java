package menu;

import implement.PressAnyKeyImpl;
import interfaces.PressAnyKey;

import java.util.Objects;
import java.util.Scanner;

import static luas_dan_volume.VolumeBangun.*;

public class Volume {
    static Scanner scanner = new Scanner(System.in);
    private static PressAnyKey pressAnyKey = new PressAnyKeyImpl();
    public static void menuVolume(){
        System.out.println("------------------------------------------");
        System.out.println("Pilih Bangunan yang akan dihitung");
        System.out.println("------------------------------------------");
        System.out.println("1. Kubus "+"\n"
                +"2. Balok "+"\n"
                +"3. Tabung " +"\n"
                +"0. kembali ke menu sebelumnya");
        System.out.println("------------------------------------------");
        System.out.print("Pilihan anda ?");
        int pilihan = scanner.nextInt();
        switch (pilihan){
            case 1:
                volumeKubus();
                pressAnyKey.pressAnyKey();
                break;
            case 2:
                volumeBalok();
                pressAnyKey.pressAnyKey();
                break;
            case 3:
                volumeTabung();
                pressAnyKey.pressAnyKey();
                break;
            case 0:
                break;
        }

    }
}
