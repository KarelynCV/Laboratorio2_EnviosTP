package modelos;

public class EnvioAereo extends Envio {
    private double tarifaBaseKm = 5.0; // más costoso por km
    private double recargoPeso = 3.5;  // recargo por kg
    private double impuestoAereo = 50.0; // tarifa fija adicional

    public EnvioAereo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        // # fórmula ajustada al transporte aéreo
        return (getDistancia() * tarifaBaseKm) + (getPeso() * recargoPeso) + impuestoAereo;
    }
}