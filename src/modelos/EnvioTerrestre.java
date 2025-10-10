package modelos;

public class EnvioTerrestre extends Envio {
    public EnvioTerrestre(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    private double tarifaBaseKm = 1.5; // tarifa por km
    private double recargoPeso = 2.0; // recargo por kg

    @Override
    public double calcularTarifa() {
        return (getDistancia() * tarifaBaseKm) + (getPeso() * recargoPeso);
    }
}