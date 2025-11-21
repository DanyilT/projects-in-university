import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class SimpleInternalFrameExample extends JFrame {

	public SimpleInternalFrameExample() {
		
		int left=0, right=0;
		
		JDesktopPane myDesktop = new JDesktopPane();
		
		setContentPane(myDesktop);
		
		left=50;
		right=50;
		
		for(int i=0; i<20; i++) {
			myDesktop.add(getFrame(100,200,left+=10,right+=10));
		}
		
		setSize(500,500);
		setVisible(true);
		
	}
	
	public JInternalFrame getFrame(int i, int j, int left, int right) {
		JInternalFrame returnFrame = new JInternalFrame();
		returnFrame.setSize(100,200);
		returnFrame.setLocation(left,right);
		returnFrame.setResizable(true);
		returnFrame.setIconifiable(true);
		returnFrame.setMaximizable(true);
		returnFrame.setClosable(true);
		returnFrame.setVisible(true);
		
		return returnFrame;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleInternalFrameExample();
	}

}
