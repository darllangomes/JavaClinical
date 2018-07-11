import java.time.LocalDate;

public class Visit {
    private Customer customer;
    private LocalDate date;
    private double serviceExpense;
    private double productExpense;
    private DiscountRate discountRate;

    public Visit(LocalDate date, String nome,DiscountRate discountRate){
        this.date = date;
        this.customer = new Customer();
        this.customer.setName(nome);
        this.discountRate = discountRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalExpense(Customer customer, DiscountRate discountRate){
        String tipo = this.customer.getMemberType();

        double desconto = this.discountRate.getProductDiscountRate(tipo);
        double desconto1 = this.discountRate.getServiceDiscountRate(tipo);
        double valor = getProductExpense();
        double valor1 =  getServiceExpense();

        double x = desconto*valor;
        double y = desconto1*valor1;

        return x+y;
    }

    public String toString(){
        String texto = "Nome: " + this.customer.getName();
        texto += "\nData: " + this.getDate();
        texto += "\nServiço: " + this.getServiceExpense();
        texto += "\nProduto: " + this.getProductExpense();
        texto += "\nO Custo Total È: " + this.getTotalExpense(customer, discountRate);

        return texto;
    }

}
