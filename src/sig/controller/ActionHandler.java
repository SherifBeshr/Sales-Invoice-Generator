package sig.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sig.model.InvoiceHeader;
import sig.model.InvoiceLine;
import sig.model.InvoiceTableModel;
import sig.view.MainFrame;
import sig.view.LineDialog;
import java.util.List;
import javax.swing.JFileChooser;
import sig.view.InvoiceDialog;
import sig.model.LinesTableModel;


public class ActionHandler implements ActionListener, ListSelectionListener{
    
    private final  MainFrame frame;
    private InvoiceDialog invoiceDialog;
    private LineDialog lineDialog;
    


    public ActionHandler(MainFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "New Invoice" -> newInv();
            case "Delete Invoice" -> deleteInv();
            case "New Item" -> newItem();
            case "Delete Item" -> deleteItem();
            case "Load File" -> loadFile();
            case "Save File" -> saveFile();
            case "New Inv Ok" -> createNewInv();
            case "New Inv Cancel" -> cancelNewInv();
            case "New Line Ok" -> createNewLine();
            case "New Line Cancel" -> cancelNewLine();
        }
    }
    
    // Displays the selected Invoice
    @Override
    public void valueChanged(ListSelectionEvent e) {
    int selectedIndex = frame.getInvoiceTable().getSelectedRow();
//        System.out.println(selectedIndex);
        if (selectedIndex != -1) {
            System.out.println("You have selected row: " + selectedIndex);
            InvoiceHeader currentInvoice = frame.getInvoices().get(selectedIndex);
            frame.getNumLabel().setText("" + currentInvoice.getNum());
            frame.getDateLabel().setText(currentInvoice.getDate());
            frame.getCustomerLabel().setText(currentInvoice.getCustomer());
            frame.getTotalLabel().setText("" + currentInvoice.getInvTotal());
            LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
            frame.getLineTable().setModel(linesTableModel);
            linesTableModel.fireTableDataChanged();
        }
    }
    
    // Creates new invoice
    private void newInv() {
        invoiceDialog = new InvoiceDialog(frame);
        invoiceDialog.setVisible(true);
    }

    // Deletes Invoice selected
    private void deleteInv() {
        int selectedRow = frame.getInvoiceTable().getSelectedRow();
        if (selectedRow != -1) {
            frame.getInvoices().remove(selectedRow);
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void newItem() {
        lineDialog = new LineDialog(frame);
        lineDialog.setVisible(true);
    }

    private void deleteItem() {
        int selectedRow = frame.getLineTable().getSelectedRow();

        if (selectedRow != -1) {
            LinesTableModel linesTableModel = (LinesTableModel) frame.getLineTable().getModel();
            linesTableModel.getLines().remove(selectedRow);
            linesTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }

    }

    // Load Files when pressing Ctrl+O
    private void loadFile() {
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                System.out.println("Invoices have been read");
                ArrayList<InvoiceHeader> invoicesArray = new ArrayList<>();
                for (String headerLine : headerLines) {
                    String[] headerParts = headerLine.split(",");
                    int invoiceNum = Integer.parseInt(headerParts[0]);
                    String invoiceDate = headerParts[1];
                    String customerName = headerParts[2];

                    InvoiceHeader invoice = new InvoiceHeader(invoiceNum, customerName , invoiceDate);
                    invoicesArray.add(invoice);
                }
                System.out.println("Check point");
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(linePath);
                    System.out.println("Lines have been read");
                    for (String lineLine : lineLines) {
                        String lineParts[] = lineLine.split(",");
                        int invoiceNum = Integer.parseInt(lineParts[0]);
                        String itemName = lineParts[1];
                        double itemPrice = Double.parseDouble(lineParts[2]);
                        int count = Integer.parseInt(lineParts[3]);
                        InvoiceHeader inv = null;
                        for (InvoiceHeader invoice : invoicesArray) {
                            if (invoice.getNum() == invoiceNum) {
                                inv = invoice;
                                break;
                            }
                        }

                        InvoiceLine line = new InvoiceLine(inv, itemName, itemPrice, count);
                        inv.getLines().add(line);
                    }
                    System.out.println("Check point");
                }
                frame.setInvoices(invoicesArray);
                InvoiceTableModel invoicesTableModel = new InvoiceTableModel(invoicesArray);
                frame.setInvoicesTableModel(invoicesTableModel);
                frame.getInvoiceTable().setModel(invoicesTableModel);
                frame.getInvoicesTableModel().fireTableDataChanged();
            }
        } catch (IOException ex) {
        }  
    }

    // Save Files when pressing Ctrl+S
    private void saveFile() {
         ArrayList<InvoiceHeader> invoices = frame.getInvoices();
        String headers = "";
        String lines = "";
        for (InvoiceHeader invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";

            for (InvoiceLine line : invoice.getLines()) {
                String lineCSV = line.getAsCSV();
                lines += lineCSV;
                lines += "\n";
            }
        }
        System.out.println("Check point");
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter lfw = new FileWriter(lineFile);
                    lfw.write(lines);
                    lfw.flush();
                    lfw.close();
                }
            }
        } catch (Exception ex) {

        }
    }

    // Pressed Ok in New Invoice Dialog
    private void createNewInv() {
        // If the text fields are Empty display warning to user
        if(invoiceDialog.getCustomerNameField().getText().equals("") || invoiceDialog.getInvoiceDateField().getText().equals("") )
        {
            JOptionPane.showMessageDialog(invoiceDialog, "Please Enter All data!");
        }
        else{
            String customerName = invoiceDialog.getCustomerNameField().getText();
            String date = invoiceDialog.getInvoiceDateField().getText();
            int num = frame.getNextInvNum();
            
            // Check for date Format
            if(isValidDate( date) == null){
                  JOptionPane.showMessageDialog(invoiceDialog, "Wrong Date Format!" ,"Date Format Error",JOptionPane.ERROR_MESSAGE );
            }
            else{          
            InvoiceHeader invoiceHeader = new InvoiceHeader(num, customerName, date);
            frame.getInvoices().add(invoiceHeader);
            frame.getInvoicesTableModel().fireTableDataChanged();
            
            invoiceDialog.dispose();
            invoiceDialog = null;
            }
        }
    }

    // Pressed Cancel in New Invoice Dialog
    private void cancelNewInv() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
    }

    private void createNewLine() {
        if(lineDialog.getItemNameField().getText().equals("") || lineDialog.getItemCountField().getText().equals("")
                || lineDialog.getItemPriceField().getText().equals(""))
        {
            JOptionPane.showMessageDialog(invoiceDialog, "Please Enter All data!");
        }
        else
        {
        String item = lineDialog.getItemNameField().getText();
        String countStr = lineDialog.getItemCountField().getText();
        String priceStr = lineDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {
            InvoiceHeader invoice = frame.getInvoices().get(selectedInvoice);
            InvoiceLine line = new InvoiceLine(invoice, item, price, count);
            invoice.getLines().add(line);
            LinesTableModel linesTableModel = (LinesTableModel) frame.getLineTable().getModel();
            linesTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
         }
    }

    // Pressed Cancel in New Line Dialog
    private void cancelNewLine() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
    }
    
    
    public Date isValidDate(String dateToValidate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(dateToValidate);
    } catch (ParseException e) {
    }
    return parsedDate;
}
    
}
