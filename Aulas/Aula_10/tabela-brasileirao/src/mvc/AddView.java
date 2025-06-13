package src.mvc;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This view shows the add new result form
//
// Lembre-se: você copiou isso de outro projeto e precisa ainda
// modificar para se adequar ao projeto atual

public class AddView extends View implements ActionListener {

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField weightField;

    public AddView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    @Override
    public void createView() {
        frame = new JFrame("Add New Person");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("ID"));
        inputPanel.add(new JLabel("Name"));
        inputPanel.add(new JLabel("Age"));
        inputPanel.add(new JLabel("Weight"));
        idField = new JTextField(4);
        inputPanel.add(idField);
        nameField = new JTextField(10);
        inputPanel.add(nameField);
        ageField = new JTextField(2);
        inputPanel.add(ageField);
        weightField = new JTextField(3);
        inputPanel.add(weightField);

        frame.add(inputPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);        
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);   

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        int weight = Integer.parseInt(weightField.getText());

        // TO-DO: call controller to deploy change to model
        System.out.println("New person: " + id + "," + name + "," + age + "(years)," + weight + "(kg)");
    }

    
}
