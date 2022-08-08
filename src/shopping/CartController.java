/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package shopping;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author rajat
 * @author arpan
 */
public class CartController  implements Initializable{

    @FXML
    private TextField tfWhite;
    @FXML
    private TextField tfWholeWheat;
    @FXML
    private TextField tfRegular;
    @FXML
    private TextField tfCappaccino;
    @FXML
    private TextField tfCafe;
    @FXML
    private Label label_sales;
    @FXML
    private Label label_total;
    @FXML
    private Button btn_total;
    @FXML
    private Button btn_reset;
    @FXML
    private Button btn_exit;
    @FXML
    private CheckBox checkCream;
    @FXML
    private CheckBox checkButter;
    @FXML
    private CheckBox checkBlue;
    @FXML
    private CheckBox checkRaso;
    @FXML
    private CheckBox checkPeach;
    @FXML
    private RadioButton radioNoneCoffee;
    @FXML
    private ToggleGroup coffee;
    @FXML
    private RadioButton radioRegular;
    @FXML
    private RadioButton radioCappacciano;
    @FXML
    private RadioButton radioCafe;
    @FXML
    private RadioButton radioNone;
    @FXML
    private RadioButton radioWhite;
    @FXML
    private RadioButton radioWholeWheat;
    @FXML
    private ToggleGroup bagel;
    @FXML
    private Label label_Subtotal;
    @FXML
    private Label errorMessage;
     @FXML
    private Label coffeeErrorMessage;
    @FXML
    private AnchorPane anchorToppings;
    
    static CalculatorMethods cal = new CalculatorMethods();
    
    static RadioButtonMethods rad = new RadioButtonMethods();
    
    static TextFieldMethods ted = new TextFieldMethods();
    
    static Price price = new Price();
    static Print pr = new Print();
    @FXML
    private Button button_PrintRecipt;
    @FXML
    private Button buttonPrintReciptPrinter;
    @FXML
    private MenuItem menuCalculate;
    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuItem menuPrintReciptPrinter;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btntotal_click(ActionEvent event)throws Exception {
        double bagelCost = bagelCost();
        double toppingCost = toppingCost();
        double coffeeCost = coffeeCost();
        double subTotal = subTotal();
        double tax = calculateTax();
        double total = calculateTotal();
        
        label_Subtotal.setText(Double.toString( subTotal ) );
        label_sales.setText(Double.toString(tax));
        label_total.setText(Double.toString( total  ));
    }

    

    @FXML
    private void btnexit_click(ActionEvent event) {
        Stage window = (Stage) btn_exit.getScene().getWindow();
        Alert alertBoxExit = new Alert(AlertType.CONFIRMATION);
        alertBoxExit.setTitle("Exit Window Confirmation");
        alertBoxExit.setContentText("Do you want to exit the Application?");
        //accessing the confirmation box result
        
        Optional<ButtonType> userAnswer = alertBoxExit.showAndWait();
        if(userAnswer.get() == ButtonType.OK){
            window.close();
        }
    }

    public double bagelCost() {
        double bagelCost = cal.bagelCostCalulator(radioWhite, radioWholeWheat, tfWhite,
                                                  tfWholeWheat);
        price.setBagelCost(bagelCost);
        return bagelCost;
    }
    
    /**
     * @return the toppingCost
     */
    public  double toppingCost(){
        double toppingCost = cal.toppingCostCalculator(radioWhite,radioWholeWheat, checkCream,
                                                       checkRaso, checkBlue, checkButter, 
                                                       checkPeach,tfWhite,tfWholeWheat);
        price.setToppingCost(toppingCost);
       return toppingCost;
        }
    /**
     * @return the Coffee Cost
     */
    public double coffeeCost() {
        double coffeeCost = cal.coffeeCostCalculator(radioCappacciano, radioNoneCoffee,
                                                     radioCafe, radioRegular, tfRegular,
                                                     tfCafe, tfCappaccino);
        price.setCoffeeCost(coffeeCost);
        return coffeeCost;
    }
    /**
     * @return the subTotal
     */
    public double subTotal(){
        double subTotal = (bagelCost()+ coffeeCost()+toppingCost());
        double subTotalValue = Math.round(subTotal*100)/100.0;
        price.setSubTotal(subTotal);
        return subTotalValue;
        }
    /**
     * @return the tax
     */
    public double calculateTax(){
        double tax = (0.13) * subTotal();
        double taxValue = Math.round(tax*100)/100.0;
        price.setTax(taxValue);
        return taxValue;
    }
    /**
     * @return the total cost including sales tax
     */
    public double calculateTotal(){
        double subTotal = subTotal();
        double total = subTotal + calculateTax();
        double totalValue = Math.round(total*100)/100.0;
        price.setTotal(totalValue);
        return totalValue;
    }
    @FXML
    private void btnreset_click(ActionEvent event) {
        resetBagel();
        resetToppings();
        resetCoffee();
        resetPrice();
    }
    /*
    *Reset  functions- resetBagel , resetToppings , resetCoffee ,resetPrice
    */
    public void resetBagel(){
        tfWhite.setText("0");
        tfWhite.setDisable(true);
        tfWholeWheat.setText("0");
        tfWholeWheat.setDisable(true);
        radioNone.setSelected(true);
        

    }
    public void resetCoffee(){
        tfRegular.setText("0");
        tfCappaccino.setText("0");
        tfCafe.setText("0");
        tfRegular.setDisable(true);
        tfCappaccino.setDisable(true);
        tfCafe.setDisable(true);
        radioNoneCoffee.setSelected(true);

    }
    public void resetToppings(){
        
        checkCream.setSelected(false);
        checkButter.setSelected(false);
        checkRaso.setSelected(false);
        checkBlue.setSelected(false);
        checkPeach.setSelected(false);
        checkCream.setDisable(true);
        checkButter.setDisable(true);
        checkRaso.setDisable(true);
        checkBlue.setDisable(true);
        checkPeach.setDisable(true);
       
    }
    public void resetPrice(){
        label_Subtotal.setText("0.00");
        label_sales.setText("0.00");
        label_total.setText("0.00");
    }
    
    @FXML
    private void radioWhiteClicked(ActionEvent event) {
        rad.radioWhiteclicked(radioWhite, tfWhite, tfWholeWheat, checkCream,
                              checkRaso, checkBlue, checkButter, checkPeach);
    }
    @FXML
    private void radioWholeClicked(ActionEvent event) {
        rad.radioWholeClicked(radioWholeWheat, tfWhite, tfWholeWheat, checkCream,
                              checkRaso, checkBlue,checkButter, checkPeach);
    }
    @FXML
    private void radioNoneClicked(ActionEvent event) {
        rad.radioNoneClicked(radioNone, radioNoneCoffee, radioRegular, radioCappacciano,
                             radioCafe, tfWhite, tfWholeWheat, checkCream, checkRaso,
                             checkBlue, checkButter, checkPeach);
        
    }

    @FXML
    private void radioNoneCoffee(ActionEvent event) {
       rad.radioNoneCoffeClicked(radioNoneCoffee, tfRegular, tfCappaccino, tfCafe);
    }

    @FXML
    private void radioRegularClicked(ActionEvent event) {
        rad.buttonRegularClicked(radioRegular, tfRegular, tfCappaccino, tfCafe);
    }

    @FXML
    private void radioCappaccinoClicked(ActionEvent event) {
        rad.radioCappaccinoClicked(radioCappacciano, tfRegular, tfCappaccino, tfCafe);

    }

    @FXML
    private void radioCafeClicked(ActionEvent event) {
        rad.radioCafeClicked(radioCafe, tfCafe, tfCappaccino, tfCafe);

    }
    
    @FXML
    private void tfWhiteAction(KeyEvent event) {
        ted.tfWhiteTextControl(tfWhite, errorMessage, radioCafe,
                               radioRegular, radioCappacciano,btn_total);
    }

    @FXML
    private void tfWholeAction(KeyEvent event) {
        ted.tfWholeTextControl(tfWholeWheat, errorMessage, radioCafe,
                               radioRegular, radioCappacciano,btn_total);
    }

    @FXML
    private void tfRegularAction(KeyEvent event) {
        ted.tfRegularTextControl(tfRegular, coffeeErrorMessage,btn_total);
    }

    @FXML
    private void tfCafeAction(KeyEvent event) {
        ted.tfCafeTextControl(tfCafe, coffeeErrorMessage,btn_total);
    }

    @FXML
    private void tfCappaccinoAction(KeyEvent event) {
        ted.tfCappaccinoTextControl(tfCappaccino, coffeeErrorMessage,btn_total);
    }

    @FXML
    private void printRecipt(ActionEvent event) throws IOException, Exception {
        textAreaAction();
        pr.saveAFile(pr.getPrintRecipt());
       
  }
    public TextArea textAreaAction(){
        TextArea area = new TextArea();
        String printArea = "********RECIPT**********\n" +
                           "**SHERIDAN BAGEL SHOP***\n" +
                           "************************\n" +
                           "PRODUCT   QUANTITY    PRICE    \n";
        printArea +=       "********BAGEL TYPE ********  \n";
        if(Integer.parseInt(tfWhite.getText()) >=1&& Integer.parseInt(tfWhite.getText())<=8 ){
            printArea += CalculatorMethods.bagelType.getName()+"             "+ 
                        +CalculatorMethods.bagelType.getQuantity()+"        "+
                         CalculatorMethods.bagelType.getPrice()+"\n";
        }
            printArea +=   "*******TOPPINGS***********\n";
        if(checkCream.isSelected()){
            printArea += CalculatorMethods.toppingCream.getName() +  "              "+
                         CalculatorMethods.toppingCream.getQuantity()+ "              "+
                         CalculatorMethods.toppingCream.getPrice()+"\n";
        }
        if(checkButter.isSelected()){
            printArea += CalculatorMethods.toppingButter.getName() +  "              "+
                         CalculatorMethods.toppingButter.getQuantity()+"              "+
                         CalculatorMethods.toppingButter.getPrice()+"\n";
        }
        if(checkRaso.isSelected()){
            printArea += CalculatorMethods.toppingRaspberry.getName() +  "         "+
                         CalculatorMethods.toppingRaspberry.getQuantity()+"              "+
                         CalculatorMethods.toppingRaspberry.getPrice()+"\n";
        }
        if(checkBlue.isSelected()){
            printArea += CalculatorMethods.toppingBlueberry.getName() +  "         "+
                         CalculatorMethods.toppingBlueberry.getQuantity()+"              "+
                         CalculatorMethods.toppingBlueberry.getPrice()+"\n";
        }
        if(checkPeach.isSelected()){
             printArea +=CalculatorMethods.toppingPeach.getName() +  "              "+
                         CalculatorMethods.toppingPeach.getQuantity()+"              "+
                         CalculatorMethods.toppingPeach.getPrice()+"\n";
        }
        printArea += "******COFFEE TYPE *********\n";
        
        printArea += CalculatorMethods.coffeeType.getName() +  "          "+
                     CalculatorMethods.coffeeType.getQuantity()+"          "+
                     CalculatorMethods.coffeeType.getPrice()+"          \n";
        printArea += "*****COST SUMMARY******\n";
        
        printArea += "Subtotal : $"+price.getSubTotal()  +"\n" +
                     "Sales Tax :  $"+ price.getTax()   +"\n"+
                     "Total Cost : $"+ price.getTotal()   +"\n";
        area.setPrefRowCount(30);
        area.setPrefColumnCount(30);
        area.setWrapText(true);       
        area.setText(printArea); 
        pr.setPrintRecipt(printArea);
        return area;
    }

    @FXML
    private void buttonReciptPrinterAction(ActionEvent event) throws Exception {
        
         TextArea area = textAreaAction();
         print(area);
    }
    public void print(Node node)throws Exception{
        Print.print(node);
    }
 }
    

