
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceTableModel extends AbstractTableModel{
    private ArrayList<InvoiceHeader> invoice;
    private String[] columns = {"No.", "Date", "Customer", "Total"};
    
    public InvoiceTableModel(ArrayList<InvoiceHeader> invoices) {
        this.invoice = invoices;
    }

    
    @Override
    public int getRowCount() {
        return invoice.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int x) {
        return columns[x];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       InvoiceHeader invoices = invoice.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> invoices.getNum();
            case 1 -> invoices.getDate();
            case 2 -> invoices.getCustomer();
            case 3 -> invoices.getInvTotal();
            default -> 0;
        };
    }
    
}
