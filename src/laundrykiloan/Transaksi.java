package laundrykiloan;

public class Transaksi {
    private Pelanggan pelanggan;
    private Layanan layanan;
    private double beratKg;
    private double totalHarga;
    private String statusCucian;

    public Transaksi(Pelanggan pelanggan, Layanan layanan, double beratKg) {
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.beratKg = beratKg;
        this.totalHarga = layanan.hitungHarga(beratKg);
        this.statusCucian = "Proses";
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public double getBeratKg() {
        return beratKg;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getStatusCucian() {
        return statusCucian;
    }

    public void setStatusCucian(String statusCucian) {
        this.statusCucian = statusCucian;
    }

    @Override
    public String toString() {
        return "Pelanggan: " + pelanggan.getNama()
                + " | Layanan: " + layanan.getJenisLayanan()
                + " | Berat: " + beratKg + " kg"
                + " | Total: Rp" + totalHarga
                + " | Estimasi: " + layanan.getEstimasiWaktu()
                + " | Status: " + statusCucian;
    }
}