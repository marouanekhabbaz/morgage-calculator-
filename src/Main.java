public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var  calculations = new Calculations(principal , annualInterest , years);
        var mortgageReport = new MortgageReport(calculations);

        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }

}

