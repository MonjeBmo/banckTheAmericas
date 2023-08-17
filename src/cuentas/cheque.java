package cuentas;

public class cheque extends cuenta {
    private double recargo; // Monto adicional a cobrar en caso de exceder la cuota mensual de transacciones
    private int cuotaMensual; // Número de transacciones permitidas en el mes

    public static int noTransacciones; // Contador de transacciones
    public static int cuota;

    // Constructor
    public cheque(double saldo, double recargo, int cuotaMensual) {
        super(saldo); // Llama al constructor de la clase padre 'cuenta' y establece el saldo inicial
        this.recargo = recargo;
        this.cuotaMensual = cuotaMensual;
        cuota = cuotaMensual;
    }

    // Método para retirar saldo
    @Override
    public double retirarSaldos(double saldo) {
        if (saldo <= this.saldo) {
            noTransacciones += 1; // Incrementa el contador de transacciones
            this.cuotaMensual -= 1; // Reduce en uno la cuota mensual disponible
            this.saldo -= saldo; // Realiza el retiro
            printTransacciones();
            return getSaldo(); // Devuelve el saldo actual
        }
        return 0; // Si no se cumple ninguna condición, devuelve 0
    }

    public void aplicarRecargo() {
        // agregando racargo
        if (cuotaMensual <= 0) {
            var add = (noTransacciones - cuota) * recargo; // Calcula el recargo por exceder transacciones
            System.out.println("Recargo : " + add);
            this.cuotaMensual -= 1; // Reduce en uno la cuota mensual disponible
            this.saldo -= add; // Realiza el retiro más el recargo
        } else {
            int x = cuotaMensual <= 0 ? 0 : cuotaMensual;
            System.out.println("\tNo se le aplica el recargo \nNo. de Transacciones sobrantes : " + x);
        }
    }

    public void printTransacciones() {
        String msj = "No. de Transaccion " + (noTransacciones);
        System.out.println(msj);
    }

    // Métodos para obtener y establecer el recargo
    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    // Métodos para obtener y establecer la cuota mensual
    public int getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(int cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    // Métodos estáticos para obtener y establecer el contador de transacciones
    public static int getNoTransacciones() {
        return noTransacciones;
    }

    public static void setNoTransacciones(int noTransacciones) {
        cheque.noTransacciones = noTransacciones;
    }

}
