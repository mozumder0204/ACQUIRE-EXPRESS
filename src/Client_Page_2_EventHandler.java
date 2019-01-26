import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client_Page_2_EventHandler implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MasterFrame refer = MasterFrame.getRefer();
		refer.setTitle("Client Page_2");
		refer.remove(Client_Page.getRefer());
		refer.add(Client_Page_2.getRefer() , BorderLayout.CENTER);
		refer.paintAll(refer.getGraphics());
	}

}
