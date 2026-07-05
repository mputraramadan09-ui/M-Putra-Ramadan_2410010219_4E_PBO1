package laundrykiloan;

public class CuciSetrika extends Layanan {

    public CuciSetrika() {
        super("Cuci + Setrika", 7000);
    }

    @Override
    public double hitungHarga(double beratKg) {
        return beratKg * getHargaPerKg();
    }

    @Override
    public String getEstimasiWaktu() {
        return "3 hari";
    }
}