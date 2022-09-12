package menu;

import java.util.Objects;
import java.util.Scanner;

import static luas_dan_volume.VolumeBangun.*;

public class Volume {
    static Scanner scanner = new Scanner(System.in);
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
                break;
            case 2:
                volumeBalok();
                break;
            case 3:
                volumeTabung();
                break;
            case 0:
                break;
        }

    }
}
