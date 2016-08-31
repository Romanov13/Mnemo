import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MnemoGui{
	
	static String initial;
	JFrame frame;
	JButton buttonNew;
	JButton buttonPlusOne;
	JTextField txtF;
	JList list;
	
	public static void main(String[] args){

	MnemoGui gui = new MnemoGui();
	gui.startGui();
	}

	public void startGui(){

	frame = new JFrame("Мнемоника 1.0");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	MyDrawPanel mdp = new MyDrawPanel();

	buttonNew = new JButton("Обработать");
	buttonNew.addActionListener(new MyActionListener());
	buttonPlusOne = new JButton("+1");
	buttonPlusOne.addActionListener(new PlusOneActionListener());

	txtF = new JTextField(20);
	
	
	list = new JList();
	list.setVisibleRowCount(15);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.addListSelectionListener(new MySelectionListener());

	JScrollPane scroller = new JScrollPane(list);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	BorderLayout layout = new BorderLayout();

	JPanel background = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panelInpt = new JPanel();
	JPanel panelTips = new JPanel();
	JPanel panelInptTop = new JPanel();
	JPanel panelInptBot = new JPanel();

	panelInptTop.add(txtF);
	panelInptTop.add(buttonNew);
	panelInptBot.add(buttonPlusOne);
	panelInpt.setLayout(new BoxLayout(panelInpt, BoxLayout.Y_AXIS));
	panelInpt.add(panelInptTop);
	panelInpt.add(panelInptBot);
	//panel1.setPreferredSize(new Dimension(355, 260));
	panel1.setBackground(Color.gray);
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	Dimension panD = new Dimension(387, 350);
	panel1.add(new JLabel("Введите число"));
	panel1.add(panelInpt);
	panel1.add(scroller);
	panel1.setPreferredSize(panD);
	
	panel2.add(BorderLayout.CENTER, panelTips);
	panel2.setPreferredSize(panD);

	JLabel labelTips1 = new JLabel("0=М,Н; 1=Г,Ж; 2=Т,Д; 3=К,Х; 4=Ч,Щ; 5=П,Б; ");
	JLabel labelTips2 = new JLabel ("6=Ш,Л; 7=С,З; 8=В,Ф; 9=Р,Ц");
	panelTips.setLayout(new BoxLayout(panelTips, BoxLayout.Y_AXIS));
	panelTips.add(labelTips1);
	panelTips.add(labelTips2);
	panelTips.add(mdp);
	
	background.setPreferredSize(new Dimension(800, 350));
	background.setBackground(Color.blue);
	background.add(panel1);
	background.add(panel2);
	frame.getContentPane().add(background);
	frame.setSize (800, 400);
	frame.setVisible(true);
	
	}
	
	

	class MyActionListener implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
	try {
	//labelTips.setText("Sent");
	TextScan txtS = new TextScan();
	initial = txtF.getText();
	ArrayList<String> memList = txtS.txtScan(initial);
	DefaultListModel memModel = new DefaultListModel();
	if (memList.isEmpty()){memList.add("Ничего не нашлось:'(");}
	for (int i=0; i<memList.size(); i++){
	
	memModel.addElement(memList.get(i));
	}
	list.setModel(memModel);
	

	} catch (IOException ex){ex.printStackTrace();}//send to process in Mnemo class
	}

	
}
	
	class PlusOneActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			try {
			TextScan txtS = new TextScan();
			ArrayList<String> memList = txtS.txtScanPlusOne(initial);
			DefaultListModel memModel = new DefaultListModel();
			if (memList.isEmpty()){memList.add("Ничего не нашлось:'(");}
			for (int i=0; i<memList.size(); i++){
				
				memModel.addElement(memList.get(i));
				}
				list.setModel(memModel);
				

				} catch (IOException ex){ex.printStackTrace();}//send to process in Mnemo class
				}

				
			}
		
	

	class MySelectionListener implements ListSelectionListener{

	public void valueChanged(ListSelectionEvent lse){
	if (!lse.getValueIsAdjusting()){
	String selection = (String) list.getSelectedValue();
	
	//mdp.setImg(selection);
	//mdp.revalidate();
	}
	}		
}

	class MyDrawPanel extends JPanel{
	
	String selection;

	public void setImg(String s){

	selection = s;
	}

	public String getImg(){

	String im = selection;
	return im;
	}
	public void paintComponent(Graphics g){
	
	//Image image = new ImageIcon(mdp.getImg).getImage();
	//g.drawImage(image, 10, 10, this);
	}	
}
}