package laundrykiloan;

public class CuciExpress extends Layanan {

    public CuciExpress() {
        super("Cuci Express", 10000);
    }

    @Override
    public double hitungHarga(double beratKg) {
        // ada biaya tambahan express
        double biayaTambahan = 5000;
        return (beratKg * getHargaPerKg()) + biayaTambahan;
    }

    @Override
    public String getEstimasiWaktu() {
        return "6 jam";
    }
}