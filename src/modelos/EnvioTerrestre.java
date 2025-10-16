package modelos;

public class EnvioTerrestre extends Envio {
    public EnvioTerrestre(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    private double tarifaBaseKm = 1500; 
    private double recargoPeso = 2000; 

    @Override
    public double calcularTarifa() {
        return (getDistancia() * tarifaBaseKm) + (getPeso() * recargoPeso);
    }
}