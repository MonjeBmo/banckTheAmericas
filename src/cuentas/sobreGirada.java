package cuentas;

public class sobreGirada extends cuenta {
    private double tasaCredito;

    public sobreGirada(double saldo, double tasaCredito) {
        super(saldo);
        this.tasaCredito = tasaCredito;
    }

    public void cargarInteres() {
        if (this.saldo < 0) {
            double interes = this.saldo * this.tasaCredito;
            this.saldo += interes;
        }
    }

    @Override
    public double retirarSaldos(double saldo) {
        if (saldo <= this.saldo) {
            this.saldo -= saldo;
            return getSaldo();
        } else {
            this.saldo -= saldo;
            System.out.println("Se hiso la transferencia pero debe " + -getSaldo());
            cargarInteres();
            return -getSaldo();
        }
    }

    // getters and setters
    public double getTasaCredito() {
        return tasaCredito;
    }

    public void setTasaCredito(double tasaCredito) {
        this.tasaCredito = tasaCredito;
    }

}
