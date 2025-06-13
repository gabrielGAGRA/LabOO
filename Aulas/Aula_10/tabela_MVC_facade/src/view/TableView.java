package LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.Controller;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStatsModel;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.TeamStats;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class TableView extends View implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;

    public TableView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    @Override
    public void createView() {

        frame = new JFrame("Tabela do Campeonato");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "P", "G", "W", "D" });
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.add(btnPanel, BorderLayout.SOUTH);

        populateTable();

    }

    public void populateTable() {
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        Collection<TeamStats> teamsStats = model.getResults();

        if (teamsStats != null) {
            for (TeamStats team : teamsStats) {
                tableModel.addRow(new Object[] { team.getName(), team.getScore(), team.getNumberOfMatches(),
                        team.getNumberOfWins(), team.getNumberOfDraws(), team.getNumberOfLosses(), team.getGoalsFor(),
                        team.getGoalsAgainst(), team.getGoalsDifference() });
            }
        }
        table.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void update() {
        populateTable();
    }

    String[][] people = { { "103", "Anna Parker", "35", "57" }, { "42", "John Smith", "54", "79" } };

    {
        for (String[] person : people) {
            tableModel.addRow(new Object[] { person[0], person[1], person[2], person[3] });
        }
    }
}
