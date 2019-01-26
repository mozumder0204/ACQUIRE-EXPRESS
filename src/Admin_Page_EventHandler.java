import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Page_EventHandler implements ActionListener  {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MasterFrame refer = MasterFrame.getRefer();
		refer.setTitle("Admin Page");
		refer.remove(Log_In.getRefer());
		refer.add(Admin_Page.getRefer() , BorderLayout.CENTER);
		refer.paintAll(refer.getGraphics());
	}

}
