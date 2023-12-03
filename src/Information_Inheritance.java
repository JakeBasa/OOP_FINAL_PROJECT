public class Information_Inheritance extends Information{

    double change;


    public Double computeTransaction(double payment, double amount){
        change = payment - amount;
        return change;
    }

    public double getNewAmount(double amount, double discount){
        return amount * discount;
    }

    public Double computeTransaction(double amount, double payment, double discount){
        change =  amount - (payment * discount);
        return change;
    }




}
