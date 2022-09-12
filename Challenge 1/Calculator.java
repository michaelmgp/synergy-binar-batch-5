

import java.util.Scanner;

import static menu.MenuLuas.menuLuas;
import static menu.Volume.menuVolume;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){

        while(true){
                menuUtama();
                if(menuUtama()==false){
                    break;
                }
            }

        }






    public static boolean menuUtama(){
        System.out.println("------------------------------------------");
        System.out.println("KALKULATOR PENGHITUNG LUAS DAN VOLUME");
        System.out.println("------------------------------------------");
        System.out.println("Menu" +"\n"
                + "1. Hitung Luas Bidang " +"\n"
                + "2. Hitung Volume" +"\n"
                + "0. Tutup Aplikasi" + "\n");
        System.out.println("------------------------------------------");
        System.out.print("Pilihan anda ? " );
        int pilihan = scanner.nextInt();
        boolean state = true;
        switch(pilihan){
            case 1:
                menuLuas();
                state=true;
                break;
            case 2:
                menuVolume();
                state=true;
                break;
            case 0:
                state=false;
                System.out.println("SAMPAI JUMPA");
                break;

        }
        return state;
    }
}









