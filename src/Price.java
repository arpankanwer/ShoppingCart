/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

/**
 * @author rajat
 * @author arpan
 */
public class Price {
    private double bagelCost;
    private double toppingCost;
    private double coffeeCost;
    private double subTotal ;
    private double tax;
    private double total;
    

    /**
     * @return the bagelCost
     */
    public double getBagelCost() {
        return bagelCost;
    }

    /**
     * @param bagelCost the bagelCost to set
     */
    public void setBagelCost(double bagelCost) {
        this.bagelCost = bagelCost;
    }

    /**
     * @return the toppingCost
     */
    public double getToppingCost() {
        return toppingCost;
    }

    /**
     * @param toppingCost the toppingCost to set
     */
    public void setToppingCost(double toppingCost) {
        this.toppingCost = toppingCost;
    }

    /**
     * @return the coffeeCost
     */
    public double getCoffeeCost() {
        return coffeeCost;
    }

    /**
     * @param coffeeCost the coffeeCost to set
     */
    public void setCoffeeCost(double coffeeCost) {
        this.coffeeCost = coffeeCost;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
