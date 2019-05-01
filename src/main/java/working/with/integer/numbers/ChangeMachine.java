package working.with.integer.numbers;

public class ChangeMachine {

  public static void calcular(double amount) {

    amount *= 100;

    double[] bills = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1};

    for (int i = 0; i < bills.length; i++) {
      if (amount >= bills[i]) {
        double n = Math.floor(amount / bills[i]);

        System.out.printf("amount=%s, bill=%s, amount=%s\n", amount / 100, bills[i] / 100, n);
        amount -= n * bills[i];
      }
    }
  }

  public static void calcular1(double monto) {
    int[] billetes = {10000, 5000, 1000, 500, 200, 100, 50, 20, 5};

    for (int i = 0; i < billetes.length; i++) {
      int cuantos = (int) (monto / billetes[i]);
      if (cuantos > 0) {
        System.out.printf("Necesitas %d billetes de %d\n", cuantos, billetes[i]);
      }
      monto = monto % billetes[i];
    }
    if (monto > 0) {
      System.out.printf("al final te sobra %s\n", monto);
    } else {
      System.out.println("y con eso queda exacto");
    }
  }
}
