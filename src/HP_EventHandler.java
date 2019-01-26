import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HP_EventHandler implements ActionListener  {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MasterFrame refer = MasterFrame.getRefer();
		refer.setTitle("HomePage");
		
		refer.remove(Log_In.getRefer());
		refer.add(HomePage.getRefer());
		refer.paintAll(refer.getGraphics());
	}
}
