package src.mvc;


// This view shows the league stats
//
// Lembre-se: você copiou isso de outro projeto e precisa ainda
// modificar para se adequar ao projeto atual

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TableView extends View implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;

    public TableView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    // Creates the GUI elements
    @Override
    public void createView() {

        frame = new JFrame("Patients");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Name", "Age", "Weight"}
        );
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        frame.add(btnPanel, BorderLayout.SOUTH);

        JButton updateButton = new JButton("Update Table");
        updateButton.addActionListener(this);
        btnPanel.add(updateButton);

        populateTable();

    }

    // Retrieves and displays data from model
    public void populateTable() {
        String[][] people = {
            {"103", "Anna Parker", "35", "57"},
            {"42", "John Smith", "54", "79"}
        };

        for (String[] person: people) {
            tableModel.addRow(new Object[] { 
                   person[0], person[1], person[2], person[3]
            });
        }
        
        table.repaint();
    }

    // Process 'Update Table' button click
    @Override
    public void actionPerformed(ActionEvent e) {
        // TO-DO
    }            

}
