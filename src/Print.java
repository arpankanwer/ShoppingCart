/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.print.PrinterJob;
import javafx.scene.Node;

/**
 * @author rajat
 * @author arpan
 */
public class Print {
    
    private String printRecipt;
    
    public static void print(Node node){
        System.out.println("Creating a printer job...");
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
              System.out.println(job.jobStatusProperty().asString());

              boolean printed = job.printPage(node);
              if (printed) {
                job.endJob();
              } else {
                System.out.println("Printing failed.");
              }
            } else {
              System.out.println("Could not create a printer job.");
        } 
    }
    public void saveAFile(String printArea)throws IOException{
        try{
        File outFile = new File("PrintRecipt.txt");
        FileOutputStream outFileStream = new FileOutputStream(outFile);
        PrintWriter output = new PrintWriter(outFileStream);
        
        output.print(printArea);
        output.close();}
        catch(IOException e ){
        }
        
        
    }

    /**
     * @return the printRecipt
     */
    public String getPrintRecipt() {
        return printRecipt;
    }

    /**
     * @param printRecipt the printRecipt to set
     */
    public void setPrintRecipt(String printRecipt) {
        this.printRecipt = printRecipt;
    }
}

