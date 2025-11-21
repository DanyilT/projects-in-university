import javax.swing.*;
import java.awt.*;

public class TextDemo extends JFrame {
  public TextDemo() {

	super("Button with Icon");
	Container contentPane = getContentPane();
	JPanel panel = new JPanel();


    // Instantiate a new TextField
	JTextField textField = new JTextField();

	// Instantiate a new TextArea
	JTextArea textArea = new JTextArea();

	// Initialize the text of each
	textField.setText("TextField");
	textArea.setText("JTextArea\n Allows Multiple Lines");

	//add the text field to the panel
	panel.add(textField);

	//add a scrollpane containing a text field to the panel
	JScrollPane myPane = new JScrollPane(textArea);
	panel.add(myPane);


	//panel.add(new JScrollPane(ta));


	//add the panel to the content pane
	contentPane.add(panel);

	//set the window properties
    setSize(300,200);
    setVisible( true );
  }

  public static void main(String args []) {

	TextDemo myFrame = new TextDemo();
	myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

  }


}//end of class