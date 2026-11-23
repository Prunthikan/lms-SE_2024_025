package lms.ui;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Magazine;
import lms.service.Library;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    private Library library;
    private DefaultTableModel tableModel;
    private JTable itemTable;
    private JComboBox<String> typeComboBox;
    private JTextField idField;
    private JTextField titleField;
    private JTextField detailField;

    private JLabel statusLabel;

    public MainFrame(Library library) {

        this.library = library;

        // Main window settings
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 460);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(5, 5));


        // NORTH - Heading Gui
        JLabel heading = new JLabel("Library Management System", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        add(heading, BorderLayout.NORTH);

        // CENTER - Table in Gui
        String[] columns = {"ID", "Title", "Type", "Detail", "Status"};

        tableModel = new DefaultTableModel(columns, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        add(scrollPane, BorderLayout.CENTER);


        // WEST - Add Item Form in Gui
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 6, 8));

        formPanel.setBorder(new TitledBorder("New Item"));

        typeComboBox = new JComboBox<>(new String[]{"Book", "DVD", "Magazine"});

        idField = new JTextField();
        titleField = new JTextField();
        detailField = new JTextField();

        formPanel.add(new JLabel("Type:"));
        formPanel.add(typeComboBox);

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);

        formPanel.add(new JLabel("Detail:"));
        formPanel.add(detailField);

        JButton addButton =new JButton("Add Item");

        formPanel.add(new JLabel(""));
        formPanel.add(addButton);


        // Wrapper panel keeps the form at natural height
        JPanel westPanel =new JPanel(new BorderLayout());

        westPanel.add(formPanel, BorderLayout.NORTH);

        add(westPanel, BorderLayout.WEST);


        // SOUTH - Status and Buttons in gui
        JPanel southPanel =new JPanel(new BorderLayout());

        statusLabel =new JLabel("Ready");

        southPanel.add(statusLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton borrowButton = new JButton("Borrow");
        JButton returnButton = new JButton("Return");

        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);

        southPanel.add(buttonPanel, BorderLayout.EAST);

        add(southPanel, BorderLayout.SOUTH);


        // Displaying the  existing library items
        refreshTable();
    }


    // Refresh the table
    public void refreshTable(){
        tableModel.setRowCount(0);
        for (LibraryItem item : library.getItems()){
            String type = "";
            String detail = "";
            if (item instanceof Book){
                Book book = (Book) item;
                type = "Book";
                detail = book.getAuthor();

            }
            else if (item instanceof DVD){
                DVD dvd = (DVD) item;
                type = "DVD";
                detail = dvd.getDurationMinutes() + " min";

            }
            else if (item instanceof Magazine) {
                type = "Magazine";
                detail = "Issue 42";
            }

            String status;
            if (item.isBorrowed()){
                status = "Borrowed";
            }
            else{
                status = "Available";
            }

            Object[] row = {
                    item.getId(),
                    item.getTitle(),
                    type,
                    detail,
                    status
            };

            tableModel.addRow(row);
        }
    }
}
