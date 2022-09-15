package implement;

import interfaces.PressAnyKey;

public class PressAnyKeyImpl implements PressAnyKey {
    @Override
    public void pressAnyKey() {
        System.out.println("Tekan ENTER Untuk Kembali Ke Menu Utama . . . . ");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
