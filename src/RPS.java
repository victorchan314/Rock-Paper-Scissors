import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RPS {
	
	static Random generator = new Random();
	public static int PlayerScore = 0;
	public static int ComputerScore = 0;
	
	public static void main(String args[]){
		
		Font ButtonFont = new Font("Comic Sans Ms",0,20);
		Font LabelFont = new Font("Comic Sans Ms",0,50);
		Font ScoreFont = new Font("Comic Sans Ms",0,25);
		
		JFrame Window = new JFrame("Rock, Paper, Scissors!");
		Window.setVisible(true);
		Window.setSize(700,500);
		Window.setLocationRelativeTo(null);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//The main panel
		final JPanel StartPanel = new JPanel();
		StartPanel.setLayout(null);
		StartPanel.setBounds(0,0,700,500);
		StartPanel.setBackground(Color.black);
		Window.add(StartPanel);
		StartPanel.setVisible(true);
		
		JButton StartButton = new JButton("Start Game");
		StartButton.setBounds(150,150,200,100);
		StartButton.setFont(ButtonFont);
		StartButton.setBackground(Color.green);
		StartButton.setForeground(Color.black);
		StartPanel.add(StartButton);
	    
	    
	    //The game window
	    final JPanel GamePanel = new JPanel();
	    GamePanel.setLayout(null);
	    GamePanel.setBounds(0,0,700,500);
	    GamePanel.setBackground(Color.black);
	    Window.add(GamePanel);
	    GamePanel.setVisible(false);
	    
	    //The game buttons
	    final JPanel GameButtons = new JPanel();
	    GameButtons.setLayout(null);
	    GameButtons.setBounds(150,200,700,500);
	    GameButtons.setBackground(Color.black);
	    GamePanel.add(GameButtons);
	    GameButtons.setVisible(false);
		
		JButton RockButton = new JButton("ROCK");
		RockButton.setBounds(0,0,200,50);
		RockButton.setFont(ButtonFont);
		RockButton.setBackground(Color.green);
		RockButton.setForeground(Color.black);
		GameButtons.add(RockButton);
		
		JButton PaperButton = new JButton("PAPER");
		PaperButton.setBounds(0,75,200,50);
		PaperButton.setFont(ButtonFont);
		PaperButton.setBackground(Color.green);
		PaperButton.setForeground(Color.black);
		GameButtons.add(PaperButton);
		
		JButton ScissorButton = new JButton("SCISSOR");
		ScissorButton.setBounds(0,150,200,50);
		ScissorButton.setFont(ButtonFont);
		ScissorButton.setBackground(Color.green);
		ScissorButton.setForeground(Color.black);
		GameButtons.add(ScissorButton);

		
		//The option panel
		final JPanel OptionPanel = new JPanel();
	    OptionPanel.setLayout(null);
	    OptionPanel.setBounds(0,0,500,500);
	    OptionPanel.setBackground(Color.black);
	    GamePanel.add(OptionPanel);
	    OptionPanel.setVisible(false);
		
		JButton Continue = new JButton("Continue");
		Continue.setBounds(150,275,200,50);
		Continue.setFont(ButtonFont);
		Continue.setBackground(Color.green);
		Continue.setForeground(Color.black);
		OptionPanel.add(Continue);
		
		JButton StartOver = new JButton("Start Over");
		StartOver.setBounds(150,350,200,50);
		StartOver.setFont(ButtonFont);
		StartOver.setBackground(Color.green);
		StartOver.setForeground(Color.black);
		OptionPanel.add(StartOver);
		
		//Game Labels
		final JLabel ComputerMove = new JLabel("Make a move!");
		ComputerMove.setBounds(80,40,340,50);
		ComputerMove.setFont(LabelFont);
		ComputerMove.setForeground(Color.green);
		OptionPanel.add(ComputerMove);

		final JLabel Result = new JLabel("");
		Result.setBounds(100,120,300,50);
		Result.setFont(LabelFont);
		Result.setForeground(Color.green);
		OptionPanel.add(Result);
		
		
		//The score panel
		final JPanel ScorePanel = new JPanel();
	    ScorePanel.setLayout(null);
	    ScorePanel.setBounds(500,0,200,500);
	    ScorePanel.setBackground(Color.black);
	    GamePanel.add(ScorePanel);
	    ScorePanel.setVisible(false);
	    
		final JLabel Player = new JLabel("Player: ");
		Player.setBounds(0,40,150,25);
		Player.setFont(ScoreFont);
		Player.setForeground(Color.green);
		ScorePanel.add(Player);
	    
		final JLabel PScore = new JLabel(Integer.toString(PlayerScore));
		PScore.setBounds(0,70,150,25);
		PScore.setFont(ScoreFont);
		PScore.setForeground(Color.green);
		ScorePanel.add(PScore);
	    
		final JLabel Computer = new JLabel("Computer: ");
		Computer.setBounds(0,110,150,25);
		Computer.setFont(ScoreFont);
		Computer.setForeground(Color.green);
		ScorePanel.add(Computer);
	    
		final JLabel CScore = new JLabel(Integer.toString(ComputerScore));
		CScore.setBounds(0,140,150,25);
		CScore.setFont(ScoreFont);
		CScore.setForeground(Color.green);
		ScorePanel.add(CScore);
		
		
		
	    StartButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	UpdateLabels(PScore,CScore);
	            StartPanel.setVisible(false);
	            GamePanel.setVisible(true);
	            GameButtons.setVisible(true);
	            ScorePanel.setVisible(true);
	       }
	    });
	    
	    RockButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	Move(1,ComputerMove,Result);
	        	UpdateLabels(PScore,CScore);
	        	GameButtons.setVisible(false);
	        	OptionPanel.setVisible(true);
	            ScorePanel.setVisible(true);
	       }
	    });
	    
	    PaperButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	Move(2,ComputerMove,Result);
	        	UpdateLabels(PScore,CScore);
	        	GameButtons.setVisible(false);
	        	OptionPanel.setVisible(true);
	            ScorePanel.setVisible(true);
	       }
	    });
	    
	    ScissorButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	Move(3,ComputerMove,Result);
	        	UpdateLabels(PScore,CScore);
	        	GameButtons.setVisible(false);
	        	OptionPanel.setVisible(true);
	            ScorePanel.setVisible(true);
	       }
	    });

	    Continue.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	GameButtons.setVisible(true);
	        	OptionPanel.setVisible(false);
	            ScorePanel.setVisible(true);
	       }
	    });
	    
	    StartOver.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	PlayerScore = 0;
	        	ComputerScore = 0;
	        	UpdateLabels(PScore,CScore);
	        	GameButtons.setVisible(true);
	        	OptionPanel.setVisible(false);
	            ScorePanel.setVisible(true);
	       }
	    });
	}
    
    public static void Move(int n, JLabel c, JLabel r){
    	int CMove = generator.nextInt(3)+1;
    	if (CMove==1){
    		c.setText("I move ROCK!");
    		c.setBounds(80,40,340,50);
    		if (n==3){
    			r.setText("You Lose!");
    			ComputerScore++;
    		}
    		else if (n==2){
    			r.setText("You Win!");
    			PlayerScore++;
    		}
    		else {
    			r.setText("Tie!");
    		}
    	}
    	else if (CMove==2){
    		c.setText("I move PAPER!");
    		c.setBounds(70,40,360,50);
    		if (n==1){
    			r.setText("You Lose!");
    			ComputerScore++;
    		}
    		else if (n==3){
    			r.setText("You Win!");
    			PlayerScore++;
    		}
    		else {
    			r.setText("Tie!");
    		}
    	}
    	else {
    		c.setText("I move SCISSOR!");
    		c.setBounds(20,40,460,50);
    		if (n==2){
    			r.setText("You Lose!");
    			ComputerScore++;
    		}
    		else if (n==1){
    			r.setText("You Win!");
    			PlayerScore++;
    		}
    		else {
    			r.setText("Tie!");
    		}
    	}
    }

    public static void UpdateLabels(JLabel p, JLabel c){
		p.setText(Integer.toString(PlayerScore));
		c.setText(Integer.toString(ComputerScore));
    }
}