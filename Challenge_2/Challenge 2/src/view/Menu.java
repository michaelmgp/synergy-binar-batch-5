package view;

import services.PengolahanRumus;
import services.RumusImpl;

import java.util.List;
import java.util.Scanner;

public class Menu extends ReadAndWrite{

    PengolahanRumus rumus;
    Scanner sc = new Scanner(System.in);
    public boolean menu(String path){
        System.out.print("-----------------------------------------------------------------\n"+
                         "Aplikasi Pengolah Nilai Siswa \n" +
                         "-----------------------------------------------------------------" +
                         "Letakkan File CSV dengan nama file data_sekolah di direktori berikut" +
                        " : D:\\Developing\\synergy-binar-batch-5\\Challenge_2\\Challenge 2\n\n" +
                        "pilih menu :\n" +
                        "1. Generate txt untuk menampilkan kelompok data\n" +
                        "2. Generate txt untuk menampilkan nilai rata-rata dan median\n" +
                        "3. Generate kedua file\n" +
                        "0. Exit"
                );
        boolean state = true;
        int pilihan = sc.nextInt();
        List<Integer> listNilaiParsed= read(path);
        Object data = new Object();
        switch (pilihan){
           case 1:
               data = rumus.kelompokData(listNilaiParsed);
               state = false;
               break;
           case 2:
               data = rumus.perhitunganLengkap(listNilaiParsed);
               state = false;
               break;
           case 3:
               data = null;
               break;
       }
        return state;
    }

}
