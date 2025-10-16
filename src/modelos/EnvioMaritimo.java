package modelos;

public class EnvioMaritimo extends Envio {
    private double tarifaBaseKm = 800;  
    private double recargoPeso = 1000;   

    public EnvioMaritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
               return (getDistancia() * tarifaBaseKm) + (getPeso() * recargoPeso);
    }
}