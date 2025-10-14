package modelos;

public class EnvioMaritimo extends Envio {
    private double tarifaBaseKm = 2.0;  // menor costo por km
    private double recargoPeso = 1.2;   // menor recargo por peso
    private double tasaPortuaria = 30.0; // tarifa fija

    public EnvioMaritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        // # fórmula ajustada al transporte marítimo
        return (getDistancia() * tarifaBaseKm) + (getPeso() * recargoPeso) + tasaPortuaria;
    }
}