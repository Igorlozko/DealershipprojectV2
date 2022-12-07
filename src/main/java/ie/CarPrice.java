package ie;

import java.util.Scanner;
import java.text.NumberFormat;

public class CarPrice {

    public static void main(String[] args) {

        double priceInitial;
        double HST;
        double PDI_CHARGE = 0.02;

        String makeModel;

        Scanner scan = new Scanner(System.in);

        System.out.print("makeModel?: ");
        makeModel = scan.nextLine().toUpperCase();
        {
            String message = "Price?: ";
            double userInput = 0;
            do {
                System.out.print("Price?: ");
                priceInitial = scan.nextDouble();
                if (priceInitial < 0) {
                    System.out.println("Enter A Value  Above 0");
                } else {
                    System.out.println(priceInitial);
                    break;
                }
            } while (true);
        }
        {
            String message = "HST?: ";
            double userInput = 0;
            do {
                System.out.print("HST?: ");
                HST = scan.nextDouble();
                if (HST < 0) {
                    System.out.println("Enter A Value  Above 0");
                } else {
                    System.out.println(HST);
                    break;
                }
            } while (true);
        }

        double tax = priceInitial * (HST / 100) + priceInitial;

        double PDI = (tax + priceInitial) * PDI_CHARGE;
        double AfterPDI = PDI + tax;

        String PDI_Print = NumberFormat.getCurrencyInstance().format(PDI);
        String tax_Print = NumberFormat.getCurrencyInstance().format(tax);
        String priceInitial_Print = NumberFormat.getCurrencyInstance().format(priceInitial);
        String tax_Amount = NumberFormat.getPercentInstance().format(HST / 100);
        String AfterPDI_Print = NumberFormat.getCurrencyInstance().format(AfterPDI);

        System.out.println("Congrats! Your " + makeModel + " is " + priceInitial_Print +
                "\n Your total after " + tax_Amount + " HST is " + tax_Print +
                "\n with a PDI fee of " + PDI_Print +
                "\n making your total " + AfterPDI_Print);


    }
}
