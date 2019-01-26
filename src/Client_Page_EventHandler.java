import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client_Page_EventHandler implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MasterFrame refer = MasterFrame.getRefer();
		
		refer.setTitle("Client Page");
		
		refer.remove(Log_In.getRefer());
		
		refer.remove(Client_Page_2.getRefer() );
		
		refer.add(Client_Page.getRefer() , BorderLayout.CENTER);
		
		refer.paintAll(refer.getGraphics());
		
	}

}
