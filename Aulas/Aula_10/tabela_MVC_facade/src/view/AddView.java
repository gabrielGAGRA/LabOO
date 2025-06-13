package LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view;

import javax.swing.*;

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.AddController;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.Controller;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStatsModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This view shows the add new result form
//
// Lembre-se: você copiou isso de outro projeto e precisa ainda
// modificar para se adequar ao projeto atual

public class AddView extends View implements ActionListener {
    private JTextField casaTime;
    private JTextField casaGols;
    private JTextField foraTime;
    private JTextField foraGols;

    public AddView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    @Override
    public void createView() {
        frame = new JFrame("Adicionar Resultado de Jogo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Time Casa:"));
        casaTime = new JTextField(3);
        inputPanel.add(casaTime);

        inputPanel.add(new JLabel("Gols Casa:"));
        casaGols = new JTextField(3);
        inputPanel.add(casaGols);

        inputPanel.add(new JLabel("Time Visitante:"));
        foraTime = new JTextField(3);
        inputPanel.add(foraTime);

        inputPanel.add(new JLabel("Gols Visitante:"));
        foraGols = new JTextField(3);
        inputPanel.add(foraGols);

        frame.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JButton addButton = new JButton("Adicionar");
        addButton.setActionCommand("add");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if ("add".equals(command)) {
            try {
                String casaTimeCode = casaTime.getText().trim().toUpperCase();
                String foraTimeCode = foraTime.getText().trim().toUpperCase();
                String casaGolsStr = casaGols.getText().trim();
                String foraGolsStr = foraGols.getText().trim();

                if (casaTimeCode.isEmpty() || foraTimeCode.isEmpty() || casaGolsStr.isEmpty()
                        || foraGolsStr.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios.", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (casaTimeCode.length() != 3 || !casaTimeCode.matches("[A-Z]{3}")) {
                    JOptionPane.showMessageDialog(frame,
                            "Código do time da casa deve ter 3 letras maiúsculas (ex: SAO).", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                    casaTime.requestFocus();
                    return;
                }
                if (foraTimeCode.length() != 3 || !foraTimeCode.matches("[A-Z]{3}")) {
                    JOptionPane.showMessageDialog(frame,
                            "Código do time visitante deve ter 3 letras maiúsculas (ex: PAL).", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                    foraTime.requestFocus();
                    return;
                }
                if (casaTimeCode.equals(foraTimeCode)) {
                    JOptionPane.showMessageDialog(frame, "Time da casa e visitante não podem ser o mesmo.",
                            "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int casaGolsInt = Integer.parseInt(casaGolsStr);
                int foraGolsInt = Integer.parseInt(foraGolsStr);

                if (casaGolsInt < 0 || foraGolsInt < 0) {
                    JOptionPane.showMessageDialog(frame, "Número de gols não pode ser negativo.", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (controller instanceof AddController) {
                    ((AddController) controller).ResultadoJogo(casaTimeCode, casaGolsInt, foraTimeCode, foraGolsInt);

                    casaTime.setText("");
                    casaGols.setText("");
                    foraTime.setText("");
                    foraGols.setText("");
                    casaTime.requestFocus();
                }
                else {
                    System.err.println("Erro");
                    JOptionPane.showMessageDialog(frame, "Erro interno ao processar o pedido.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Gols devem ser números inteiros válidos.", "Erro de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if ("cancel".equals(command)) {
            frame.dispose();
        }
    }
}