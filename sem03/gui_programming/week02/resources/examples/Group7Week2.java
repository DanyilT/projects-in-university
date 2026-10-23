import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Group7Week2 extends JFrame {

	public static void main(String[] args) {
		new Group7Week2();

	}
	
	public Group7Week2() {
		
		Font bigFont = new Font("Ariel",Font.BOLD, 40);
		JLabel bannerLabel = new JLabel("Premier League Live Match");
		bannerLabel.setFont(bigFont);
		JPanel bannerPanel = new JPanel();
		bannerPanel.add(bannerLabel);
		
		JPanel resultsPanel = new JPanel();
		JLabel homeLabel = new JLabel("Man U");
		JLabel awayLabel = new JLabel("Spurs");
		JLabel commentLabel = new JLabel("Commentary");
		
		JTextField resultsHomeField = new JTextField(10);
		JTextField resultsAwayField = new JTextField(10);
		
		JTextArea commentaryArea = new JTextArea(20,40);
		JScrollPane commentaryScroller = new JScrollPane(commentaryArea);
		
		resultsPanel.add(homeLabel);
		resultsPanel.add(resultsHomeField);
		resultsPanel.add(awayLabel);
		resultsPanel.add(resultsAwayField);
		resultsPanel.add(commentLabel);
		resultsPanel.add(commentaryScroller);
		
		getContentPane().add(resultsPanel);
		getContentPane().add(bannerPanel,BorderLayout.NORTH);

		
		setSize(600,600);
		setVisible(true);
	}

}
