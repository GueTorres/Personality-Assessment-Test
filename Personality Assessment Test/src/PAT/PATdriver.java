package PAT;

public class PATdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		javax.swing.SwingUtilities.invokeLater( new Runnable(){
			@Override
			public void run() {
			
				PATGUI gui = new PATGUI();//Players choose character
			}
		});
		
	}

}
