package com.example.challenge_3.view;

import com.example.challenge_3.read_and_write.ReadAndWrite;
import com.example.challenge_3.services.PengolahanRumus;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu extends ReadAndWrite {
    PengolahanRumus rumus = new PengolahanRumus();
    Scanner sc = new Scanner(System.in);
    public boolean menuUtama() {
        String path = "D:\\Developing\\synergy-binar-batch-5\\Challenge_2\\Challenge 2\\data_sekolah.csv";
        System.out.println("-----------------------------------------------------------------\n" +
                "Aplikasi Pengolah Nilai Siswa \n" +
                "-----------------------------------------------------------------\n" +
                "Letakkan File CSV dengan nama file data_sekolah di direktori berikut" +
                " : D:\\Developing\\synergy-binar-batch-5\\Challenge_2\\Challenge 2\n\n" +
                "pilih menu :\n" +
                "1. Generate txt untuk menampilkan kelompok data\n" +
                "2. Generate txt untuk menampilkan nilai rata-rata dan median\n" +
                "3. Generate kedua file\n" +
                "0. Exit"
        );

        Map<String, String> data = new HashMap<>();
        Map<String, String> data2;
        int pilihan = sc.nextInt();
        boolean state = false;
        try{
            if (pilihan != 0) {
                state = readFile(path);
                if(state==false){
                    List<Integer> listNilaiParsed = convertedData(path);
                    if (pilihan == 1)
                        data = rumus.kelompokData(listNilaiParsed);
                    if (pilihan == 2)
                        data = rumus.perhitunganLengkap(listNilaiParsed);
                    if (pilihan == 3) {
                        data = rumus.kelompokData(listNilaiParsed);
                        data2 = rumus.perhitunganLengkap(listNilaiParsed);
                        return writeFile(data, data2);
                    }if(pilihan == 0){
                        return false;
                    }
                    return writeFile(data, pilihan);
                }
            }

        }catch (IOException | IllegalArgumentException e){
            System.out.println("Terjadi Errror " +e);
            e.printStackTrace();
        }

        return state;
    }


}
