package PAT;


import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class PATGUI extends JFrame implements ActionListener {
	
	private textFileHandlerPAT tfHandler = new textFileHandlerPAT();
	private JButton jbCreateFile, jbDisplayFile, jbDisplay1stLine, jbDeleteFile,
	jbWriteToFile, jbCopyFile;
	private JTextArea jTextArea;
	private static final int GUI_WIDTH = 500;
	private static final int GUI_HEIGHT = 500;
	private static final int NUM_COLS_TEXT_AREA = GUI_WIDTH/15;
	private static final int NUM_ROWS_TEXT_AREA = GUI_HEIGHT/20;
	private static final String ACTION_COMMAND_CREATE_FILE = "Create a File";
	//can do the same for others to avoid typo problems
	
	public PATGUI(){
		JPanel mainJP = new JPanel();
		mainJP.setBackground(Color.MAGENTA);
		jbCreateFile = new JButton(ACTION_COMMAND_CREATE_FILE);//can do the same for others to avoid typo problems
		jbDisplayFile = new JButton("Display Entire File");
		jbDisplay1stLine = new JButton("Display 1st Line");
		jbDeleteFile = new JButton("Delete File");
		//more here
		jbCreateFile.addActionListener(this);
		jbDisplayFile.addActionListener(this);
		jbDisplay1stLine.addActionListener(this);
		jbDeleteFile.addActionListener(this);
		
		jTextArea = new JTextArea(NUM_ROWS_TEXT_AREA,NUM_COLS_TEXT_AREA);
				
		mainJP.add(jbCreateFile);
		mainJP.add(jbDisplayFile);
		mainJP.add(jbDisplay1stLine);
		mainJP.add(jbDeleteFile);
		//more here
		mainJP.add(jTextArea);
		add(mainJP);
		setSize(GUI_WIDTH, GUI_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String btnFace = e.getActionCommand();
			//		e.getSource();
	switch(btnFace){
		case ACTION_COMMAND_CREATE_FILE://can do the same for others to avoid typo problems
			//use the fileName getText from JLabel, or use an InputDialog
			//to get the file name, then use the TextFileHandler Object
			//to create a new file
			createNewFile(); 
			break;
		case "Display Entire File":
			//can do the same for others to avoid typo problems
			displayEntireFile();
		break;

		case "Write to file":
			tfHandler.appendToFile("myFiles/personality.txt", jTextArea.getText());
	
	}
		
	}
	
	
	private void displayEntireFile() {
		String fileName = "myFiles/personality.txt";
		//fileName = jTextField.getText();//get from the textfield where the user types the filename
		String fileContent = tfHandler.readFile(fileName);
		jTextArea.append(fileContent);
	}


	private void createNewFile(){
		String fileName = "myFiles/assessment.txt";
				//fileName = jTextField.getText();//get from the textfield where the user types the filename
		tfHandler.createNewFile(fileName); //use your tfHandler
		jTextArea.append("Done creating file"+fileName);
		//update the display to notify user that the file was created
	
	
	}
}
