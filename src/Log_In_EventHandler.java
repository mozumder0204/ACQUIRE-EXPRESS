import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Log_In_EventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MasterFrame refer = MasterFrame.getRefer();
		
		refer.setTitle("Log In");
		
		refer.remove(HomePage.getRefer());
		
		refer.remove(Client_Page.getRefer());
		
		refer.remove(Admin_Page.getRefer());
		
		refer.add(Log_In.getRefer() , BorderLayout.CENTER);
		
		refer.paintAll(refer.getGraphics());
	
	
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

}
