package laundrykiloan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== SISTEM LAUNDRY KILOAN ===");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Riwayat Transaksi");
            System.out.println("3. Update Status Cucian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = inputAngka();

            switch (pilihan) {
                case 1:
                    tambahTransaksi();
                    break;
                case 2:
                    lihatRiwayat();
                    break;
                case 3:
                    updateStatus();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }

    static int inputAngka() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void tambahTransaksi() {
        try {
            System.out.print("Nama pelanggan: ");
            String nama = scanner.nextLine();

            System.out.print("No HP: ");
            String noHp = scanner.nextLine();

            Pelanggan pelanggan = new Pelanggan(nama, noHp);

            System.out.println("Pilih jenis layanan:");
            System.out.println("1. Cuci Reguler (Rp5000/kg)");
            System.out.println("2. Cuci + Setrika (Rp7000/kg)");
            System.out.println("3. Cuci Express (Rp10000/kg + Rp5000)");
            System.out.print("Pilihan: ");
            int pilihLayanan = inputAngka();

            Layanan layanan;
            switch (pilihLayanan) {
                case 1:
                    layanan = new CuciReguler();
                    break;
                case 2:
                    layanan = new CuciSetrika();
                    break;
                case 3:
                    layanan = new CuciExpress();
                    break;
                default:
                    System.out.println("Pilihan layanan tidak valid, transaksi dibatalkan.");
                    return;
            }

            System.out.print("Berat cucian (kg): ");
            double berat = Double.parseDouble(scanner.nextLine());

            if (berat <= 0) {
                System.out.println("Berat tidak boleh 0 atau negatif!");
                return;
            }

            Transaksi transaksi = new Transaksi(pelanggan, layanan, berat);
            daftarTransaksi.add(transaksi);

            System.out.println("Transaksi berhasil ditambahkan!");
            System.out.println("Total bayar: Rp" + transaksi.getTotalHarga());

        } catch (NumberFormatException e) {
            System.out.println("Input berat harus berupa angka!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    static void lihatRiwayat() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTransaksi.get(i));
        }
    }

    static void updateStatus() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        lihatRiwayat();
        System.out.print("Pilih nomor transaksi yang mau diupdate: ");
        int nomor = inputAngka();

        if (nomor < 1 || nomor > daftarTransaksi.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Transaksi transaksi = daftarTransaksi.get(nomor - 1);
        System.out.println("Pilih status baru:");
        System.out.println("1. Proses");
        System.out.println("2. Selesai");
        System.out.println("3. Diambil");
        int statusBaru = inputAngka();

        switch (statusBaru) {
            case 1:
                transaksi.setStatusCucian("Proses");
                break;
            case 2:
                transaksi.setStatusCucian("Selesai");
                break;
            case 3:
                transaksi.setStatusCucian("Diambil");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.println("Status berhasil diupdate!");
    }
}