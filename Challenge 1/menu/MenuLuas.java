package menu;

import java.util.Scanner;

import static luas_dan_volume.LuasBidang.*;

public class MenuLuas {
    static Scanner  scanner = new Scanner(System.in);
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
                break;
            case 2:
                luasLingkaran();
                break;
            case 3:
                luasSegitiga();
                break;
            case 1:
                luasPersegi();
                break;
            case 0:
                break;
        }



    }

}
