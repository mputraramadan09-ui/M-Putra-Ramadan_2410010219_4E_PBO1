package laundrykiloan;

public class CuciReguler extends Layanan {

    public CuciReguler() {
        super("Cuci Reguler", 5000);
    }

    @Override
    public double hitungHarga(double beratKg) {
        return beratKg * getHargaPerKg();
    }

    @Override
    public String getEstimasiWaktu() {
        return "2 hari";
    }
}