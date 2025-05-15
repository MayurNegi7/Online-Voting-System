
package internshipsproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VotingSystem extends JFrame implements ActionListener {
    private JComboBox<String> candidateList;
    private JButton voteButton;
    private JTextArea resultArea;
    
    private String[] candidates = {"Candidate A", "Candidate B", "Candidate E"};
    private int[] votes = new int[candidates.length];
    
    public VotingSystem() {
        setTitle("Online Voting System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        candidateList = new JComboBox<>(candidates);
        panel.add(candidateList, BorderLayout.NORTH);
        
        voteButton = new JButton("Vote");
        voteButton.addActionListener(this);
        panel.add(voteButton, BorderLayout.CENTER);
        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        panel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voteButton) {
            int selectedIndex = candidateList.getSelectedIndex();
            if (selectedIndex != -1) {
                votes[selectedIndex]++;
                updateResults();
                JOptionPane.showMessageDialog(this, "Vote casted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a candidate to vote.");
            }
        }
    }
    
    private void updateResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current Results:\n");
        for (int i = 0; i < candidates.length; i++) {
            sb.append(candidates[i]).append(": ").append(votes[i]).append(" votes\n");
        }
        resultArea.setText(sb.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VotingSystem());
    }
}
