import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** 
* The main class that uses all of the provided classes with a GUI
* @author Shobhit
* @version 1.0
*/
public class clsGame extends JFrame implements ActionListener{
	//GUI Variables
	JPanel pnlTOP = new JPanel(), pnlLEFT = new JPanel(new BorderLayout()), pnlBOT = new JPanel(), 
		pnlRIGHT = new JPanel(), pnlCENTER = new JPanel(), pnlLEFT_TOP = new JPanel();
	Timer tmrANIM = new Timer(1, this);
	JLabel lblTITLE = new JLabel("CHESS"), lblSTATS = new JLabel("No text"), 
		lblLEFT_TITLE = new JLabel("Move List", SwingConstants.CENTER);
	JMenuBar MAIN_MENU = new JMenuBar();
	JMenu mnuGAME = new JMenu("Game");
	JMenuItem mnuGAME_NEW = new JMenuItem("New Game"), mnuGAME_SAVE = new JMenuItem("Save Game"),
		mnuGAME_LOAD = new JMenuItem("Load Game"), mnuGAME_EXIT = new JMenuItem("Exit");
		//List of all moves made by player
	JList<String> MOVE_LIST = new JList<String>();

	ChessGame instGAME;
	/** 
	* Constructor for the main class
	* @param W Width of the GUI window
	* @param H Height of the GUI window
	*/
	public clsGame(int W ,int H){
		//Initial Setup
		super("Chess");
		setBounds(this.getToolkit().getScreenSize().width / 2 - W / 2, 
			this.getToolkit().getScreenSize().height / 2 - H / 2, W, H);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add J Components
		this.setLayout(new BorderLayout());
		
			//TOP
		this.add(pnlTOP, BorderLayout.NORTH);
		pnlTOP.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		pnlTOP.add(lblTITLE);
		lblTITLE.setFont(new Font("Ubuntu", 40, 40));

			//BOTTOM
		this.add(pnlBOT, BorderLayout.SOUTH);
		pnlBOT.setBorder(BorderFactory.createEtchedBorder());
		pnlBOT.add(lblSTATS);
		lblSTATS.setFont(new Font("Century Gothic", 20, 20));
		

			//LEFT
		this.add(pnlLEFT,BorderLayout.WEST);
		pnlLEFT.setPreferredSize(new Dimension(getWidth() / 4, getHeight()));
		pnlLEFT.setBorder(BorderFactory.createBevelBorder(0));
		pnlLEFT.add(pnlLEFT_TOP, BorderLayout.NORTH);
		pnlLEFT_TOP.add(lblLEFT_TITLE);
		lblLEFT_TITLE.setFont(new Font("Century Gothic", 20, 20));
		pnlLEFT.add(MOVE_LIST);
		MOVE_LIST.setFont(new Font("URW Chancery L", 25, 25));

			//RIGHT
		this.add(pnlRIGHT,BorderLayout.EAST);
	
			//CENTER
		this.add(pnlCENTER,BorderLayout.CENTER);
			//MENU BAR
		this.setJMenuBar(MAIN_MENU);
		MAIN_MENU.add(mnuGAME);
		mnuGAME.add(mnuGAME_NEW);
		mnuGAME_NEW.addActionListener(this);
		mnuGAME.add(mnuGAME_SAVE);
		mnuGAME_SAVE.addActionListener(this);
		mnuGAME.add(mnuGAME_LOAD);
		mnuGAME_LOAD.addActionListener(this);
		mnuGAME.add(mnuGAME_EXIT);
		mnuGAME_EXIT.addActionListener(this);

		setVisible(true);
		
		//Start game
		instGAME = new ChessGame(pnlCENTER, lblSTATS, MOVE_LIST);
		pnlCENTER.addMouseListener(instGAME);
		
	}

	public static void main (String args[]){
		//Obj instance for clsGame
		clsGame ABC = new clsGame(787, 720);

	}

	public void actionPerformed(ActionEvent event){
		//Menu options
			//NEW GAME
		if(event.getSource() == mnuGAME_NEW){
			//JOptionPane.showMessageDialog(null, "New game");
			instGAME.resetGame();
		}
			//SAVE CURRENT GAME
		else if(event.getSource() == mnuGAME_SAVE){
			String FName = JOptionPane.showInputDialog(null, "Enter filename", "Save Game", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Save game");
		
		}
			//LOAD SAVED GAME
		else if(event.getSource() == mnuGAME_LOAD){
			JOptionPane.showMessageDialog(null, "Load game");
		}
			//EXIT APPLICATION
		else if(event.getSource() == mnuGAME_EXIT){
			System.exit(0);
		}

	}


}