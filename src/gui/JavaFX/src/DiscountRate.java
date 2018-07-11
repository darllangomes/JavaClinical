public class DiscountRate {
    private double serviceDiscountPremium = 0.2;
    private double serviceDiscountGold = 0.15;
    private double serviceDiscountSilver = 0.1;
    private double productDiscountPremium = 0.1;
    private double productDiscountGold = 0.1;
    private double productDiscountSilver = 0.1;


    public double getServiceDiscountRate(String type){
        double valor = 0.0;
        if(type == "Premium"){
            valor = this.serviceDiscountPremium;
        }
        else if(type == "Gold"){
            valor = this.serviceDiscountGold;
        }
        else if(type == "Silver"){
            valor = this.serviceDiscountSilver;
        }

        return valor;
    }

    public double getProductDiscountRate(String type){
        double valor = 0.0;
        if(type == "Premium"){
            valor = this.productDiscountPremium;
        }
        else if(type == "Gold"){
            valor = this.productDiscountGold;
        }
        else if(type == "Silver"){
            valor = this.productDiscountSilver;
        }

        return valor;
    }
}
