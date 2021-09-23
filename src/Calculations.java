import java.text.NumberFormat;

public class Calculations {

   private final static byte MONTHS_IN_YEAR = 12;
  private    final static byte PERCENT = 100;

    private    int principal;
    private    float annualInterest;
    private     byte years;



    public Calculations(int principal, float annualInterest, byte years) {
        this.annualInterest = annualInterest;
        this.principal = principal;
        this.years = years;
    }

    public    double calculateBalance( short month) {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 +  monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, month))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }



    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double[] getRemainingBalance(){
        double[] balances =new double[(int) getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month-1]= calculateBalance(month);
        }
        return  balances;
    }




    private float getNumberOfPayments() {
        float numberOfPayments = years * MONTHS_IN_YEAR;
        return numberOfPayments;
    }

    private float getMonthlyInterest() {
        float monthlyInterest =annualInterest / PERCENT / MONTHS_IN_YEAR;
        return monthlyInterest;
    }
}
