import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MasterFrame extends JFrame {
	
	private static MasterFrame refer;	

	
	private MasterFrame(){
		refer = this;
		this.add(HomePage.getRefer(), BorderLayout.CENTER);
		this.setBounds(500,100,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static MasterFrame getRefer(){
		if(refer==null)
			refer = new MasterFrame();
		return refer;
	}

}
