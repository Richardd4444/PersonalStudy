public class Parameters {
    public static double calculateTotalMealPrice(double listedMealPrice, double tipRate, double taxRate){
        double tip = tipRate * listedMealPrice;
        double tax = taxRate * listedMealPrice;
        double result = listedMealPrice + tip + tax;
        System.out.println("Your total meal price is " + result);
        return result;
    }

    public static void main(String[] args){
        double groupTotalMeal = calculateTotalMealPrice(15,.2,.08);
        System.out.println(groupTotalMeal);
    }
}
