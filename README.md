# Jerarquía de Cuentas Bancarias - Resumen

Este proyecto implementa una jerarquía de clases en Java para simular diferentes tipos de cuentas bancarias en el Banco Las Américas. Cada tipo de cuenta tiene funcionalidades específicas y comparte algunas características comunes.

## Clases y Funcionalidades

### CuentaBancaria
- Clase base que contiene métodos comunes para todas las cuentas.
- Métodos:
  - `depositarFondos(double cantidad)`: Deposita una cantidad especificada en la cuenta.
  - `getSaldo()`: Obtiene el saldo actual de la cuenta.
  - `retirarFondos(double cantidad)`: Retira una cantidad de fondos de la cuenta.
  - `protected void setSaldo(double nuevoSaldo)`: Actualiza el saldo de la cuenta.

### CuentaAhorros
- Hereda de `CuentaBancaria`.
- Métodos adicionales:
  - `sumarInteres()`: Calcula e incrementa el saldo de acuerdo a la tasa de interés.
  - `setTasaInteres(double tasaInteres)`: Establece la tasa de interés.
  - `getTasaInteres()`: Obtiene la tasa de interés.

### CuentaPlazoFijo
- Hereda de `CuentaBancaria`.
- Métodos adicionales:
  - `esVencimiento()`: Verifica si ha vencido el plazo de la cuenta.
  - `vencimiento()`: Realiza acciones al vencer el plazo.
  - `getTasaRecargo()`: Obtiene la tasa de recargo por retiro anticipado.
  - `setTasaRegargo(double tasa)`: Establece la tasa de recargo.
  - Redefine `retirarFondos()` para considerar el vencimiento y aplicar cargos.

### CuentaCheques
- Hereda de `CuentaBancaria`.
- Métodos adicionales:
  - `aplicarRecargos()`: Aplica recargos por exceso de transacciones.
  - `getRecargo()`: Obtiene el recargo por transacción adicional.
  - `setRecargo(double recargo)`: Establece el recargo por transacción adicional.
  - `getCoutaMensual()`: Obtiene la cuota mensual de transacciones.
  - `setCoutaMensual(int cuota)`: Establece la cuota mensual de transacciones.
  - `getCuentaTrasacciones()`: Obtiene el número total de transacciones realizadas.
  - Redefine `retirarFondos()` para controlar el número de transacciones.

### CuentaSobregirada
- Hereda de `CuentaBancaria`.
- Métodos adicionales:
  - `cargarInteres()`: Aplica cargos de interés al saldo negativo.
  - `getTasaCredito()`: Obtiene la tasa de crédito por saldo negativo.
  - `setTasaCredito(double tasa)`: Establece la tasa de crédito por saldo negativo.
  - Puede redefinir `retirarFondos()` para considerar el manejo de cheques sobregirados.

## Documentación

El código fuente de todas las clases implementadas se encuentra en este repositorio. Cada clase está debidamente comentada para explicar su funcionamiento y relación con otras clases. Además, se incluyen capturas de pantalla de la ejecución del programa para visualizar su funcionamiento.
