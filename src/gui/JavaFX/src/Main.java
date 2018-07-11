import java.time.LocalDate;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Customer b[] = new Customer[3];

        b[0] = new Customer("Henrique", true, "Premium");
        b[1] = new Customer("Darllan", true, "Silver");
        b[2] = new Customer("Danilo", true,"Gold");

        DiscountRate z = new DiscountRate();

        LocalDate a[] = new LocalDate[3];

        a[0] = LocalDate.of(2018, 05, 15);
        a[1] = LocalDate.of(2018, 04, 02);
        a[2] = LocalDate.of(2018, 03,30);

        z.getProductDiscountRate(b[0].getMemberType());
        z.getProductDiscountRate(b[1].getMemberType());
        z.getProductDiscountRate(b[2].getMemberType());

        z.getServiceDiscountRate(b[0].getMemberType());
        z.getServiceDiscountRate(b[1].getMemberType());
        z.getServiceDiscountRate(b[2].getMemberType());

        Visit x = new Visit(a[0], b[0].getName(), z);
        Visit w = new Visit(a[1], b[1].getName(), z);
        Visit n = new Visit(a[2], b[2].getName(), z);

        x.setCustomer(b[0]);
        w.setCustomer(b[1]);
        n.setCustomer(b[2]);

        x.getTotalExpense(b[0], z);
        w.getTotalExpense(b[1], z);
        n.getTotalExpense(b[2], z);
        
        x.setProductExpense(22.4);
        w.setProductExpense(40.5);
        n.setProductExpense(57.4);
        
        x.setServiceExpense(66.5);
        w.setServiceExpense(80.6);
        n.setServiceExpense(55.6);
        
        System.out.println(x.toString());
        System.out.println();
        System.out.println(w.toString());
        System.out.println();
        System.out.println(n.toString());
    }
}
