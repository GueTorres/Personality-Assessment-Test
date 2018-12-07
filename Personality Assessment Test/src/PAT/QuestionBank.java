package PAT;

public class QuestionBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		private  String [] questions;
	    private int currQuestionIndex;
	    public static final int NUM_QUESTIONS = 10; 
	    
	    public QuestionBank(){
	        questions = new String [NUM_QUESTIONS]; //increase array size if you will add more questions
	        populateQuestionArray();
	        getNextQuestion();
	        
	    }
	    
	    private void populateQuestionArray(){
	        questions[0]= "Which three words describe you best?";
	        questions[1]= "Which is your best feature?";
	        questions[2]= "Which common saying or phrase describes you?";
	        questions[3]= "What’s the best thing that’s happened to you this week?";
	        questions[4]= "Who was your role model when you were a child?";
	        questions[5]= "Who was your favorite teacher and why?";
	        questions[6]= "What was your favorite subject at school?";
	        questions[7]= "What did you want to be when you grew up?";
	        questions[8]= "If you could have one wish come true what would it be?";
	        questions[9]= "Which would you prefer — three wishes over five years or one wish right now?";
	        /*add more questions if you like so the experience seems more realistic when randomly selecting
	        remember the number of questions cannot exceed the length of the array*/
	    }
	    public String getNextQuestion() {
	  
	        for (int i = 0; i < 10; i++) { 
	            int rand = (int)(Math.random() * 8) + 1; 
	  
	            System.out.println(questions[rand]); 
	    	//do stuff in here to get the next question.. randomly from the array...
	        }
	    	

	        
	    }

	}
}
