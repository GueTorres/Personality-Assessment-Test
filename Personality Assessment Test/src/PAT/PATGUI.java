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
	private static final int GUI_WIDTH = 1000;
	private static final int GUI_HEIGHT = 500;
	private static final int NUM_COLS_TEXT_AREA = GUI_WIDTH/15;
	private static final int NUM_ROWS_TEXT_AREA = GUI_HEIGHT/200;
	private static final String ACTION_COMMAND_CREATE_FILE = "Start Session";
	//can do the same for others to avoid typo problems
	
	public PATGUI(){
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new GridLayout(3, 3));
		mainJP.setBackground(Color.MAGENTA);
		jbCreateFile = new JButton(ACTION_COMMAND_CREATE_FILE);//can do the same for others to avoid typo problems
		//more here		
		jbDisplayQA = new JButton("View all Q & A");
		jbDisplayLongestWord = new JButton("View Longest Words");
		jbDisplayLWordAB = new JButton("View Longest Words Alphabetically");
		jbNextQuestion = new JButton("Next Question");
		
		jlAnswer = new JLabel("Answer", SwingConstants.LEFT);
		jlSession = new JLabel("Session# "/** + question.getSessionNumber() + question.Question()**/, SwingConstants.CENTER);
		
		//more here
		jbCreateFile.addActionListener(this);
		jbDisplayFile.addActionListener(this);
		jbDisplay1stLine.addActionListener(this);
		jbDeleteFile.addActionListener(this);
		
		jTextArea = new JTextArea(NUM_ROWS_TEXT_AREA,NUM_COLS_TEXT_AREA);
				
		mainJP.add(jbCreateFile, 1, 0);
		//mainJP.add(jlSession, 0, 3);		
		mainJP.add(jlAnswer, 0, 2);		
		mainJP.add(jTextArea, 1, 2);		
		mainJP.add(jbNextQuestion, 1, 0);		
		mainJP.add(jbDisplayQA, 1, 1);
		mainJP.add(jbDisplayLongestWord, 2, 1);
		mainJP.add(jbDisplayLWordAB, 0, 1);
		
		/**mainJP.add(jbCreateFile);
		mainJP.add(jbDisplayFile);
		mainJP.add(jbDisplay1stLine);
		mainJP.add(jbDeleteFile);
		//more here**/
		jbCreateFile.setVisible(true);
		jTextArea.setVisible(false);
		jlSession.setVisible(false);
		jlAnswer.setVisible(false);
		jbNextQuestion.setVisible(false);
		jbDisplayQA.setVisible(false);
		jbDisplayLongestWord.setVisible(false);
		jbDisplayLWordAB.setVisible(false);
		//move here
		
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
				jbCreateFile.setVisible(false);
			jTextArea.setVisible(true);
			jlSession.setVisible(true);
			jlAnswer.setVisible(true);
			jbNextQuestion.setVisible(true);
			jbDisplayQA.setVisible(true);
			jbDisplayLongestWord.setVisible(true);
			jbDisplayLWordAB.setVisible(true);
			
			break;
			
		case "View all Q & A":
			//can do the same for others to avoid typo problems
			displayEntireFile();
		break;
		
		case "View Longest Words":
			//can do the same for others to avoid typo problems
			displayEntireFile();
		break;
		
		case "View Longest Words Alphabetically":
			//can do the same for others to avoid typo problems
			displayEntireFile();
		break;
		
		case "Next Question":
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
