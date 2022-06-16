package sig.model;

import java.util.ArrayList;


/**
 *
 * @author Sherif
 */
public class InvoiceHeader {
    private int num;
    private String date;
    private String customer;
    private ArrayList<InvoiceLine> lines;
    
     public InvoiceHeader(){}

    public InvoiceHeader(int num, String customer, String date) {
        this.num = num;
        this.customer = customer;
        this.date = date;
    }

    public double getInvTotal(){
        double total = 0;
        for(InvoiceLine line: getLines()){
            total += line.getLineTotal();
        }
        return total;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
    
    @Override
    public String toString() {
        return "Invoice{" + "num=" + num + ", date=" + date + ", customer=" + customer + '}';
    }
    
    public String getAsCSV() {
        return num + "," + date + "," + customer;
    }
}
