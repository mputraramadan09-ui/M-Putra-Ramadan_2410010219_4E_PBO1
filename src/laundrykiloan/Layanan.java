package laundrykiloan;

public abstract class Layanan {
    private String jenisLayanan;
    private double hargaPerKg;

    public Layanan(String jenisLayanan, double hargaPerKg) {
        this.jenisLayanan = jenisLayanan;
        this.hargaPerKg = hargaPerKg;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public double getHargaPerKg() {
        return hargaPerKg;
    }

    public void setHargaPerKg(double hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }

    // method abstrak, wajib di-override tiap class anak (polymorphism)
    public abstract double hitungHarga(double beratKg);

    public abstract String getEstimasiWaktu();
}