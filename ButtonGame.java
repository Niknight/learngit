import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonGame extends JFrame implements ActionListener{
	private static int BUTSIZE=20;
	private static int BUTROW=20;
	private static int BUTCOLUMN=20;
	private JButton[][] but;
	private JButton cfg;
	private JButton rst;
	private JButton sty;
	private int determ=0;
	private int[] nx={0,0,-1,0,1};
	private int[] ny={0,1,0,-1,0};
	public ButtonGame(){
		super("ButtonGame");
		Container c=getContentPane();
		c.setLayout(new BorderLayout(1,1));
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(BUTROW,BUTCOLUMN,1,1));
		rst=new JButton("Reset");
		rst.addActionListener(this);
		sty=new JButton("stay");
		sty.addActionListener(this);
		cfg=new JButton("configue");
		cfg.addActionListener(this);
		but=new JButton[BUTROW][BUTCOLUMN];
		for(int i=0;i<but.length;i++)
			for(int j=0;j<but[i].length;j++){
				but[i][j]=new JButton();
				jp.add(but[i][j]);
				but[i][j].setBackground(Color.green);
				//if((i<but.length-1||j>0&&j<but[i].length-1)){
					but[i][j].addActionListener(this);
				//	}
				//else but[i][j].setVisible(false);
				}
		c.add(jp,BorderLayout.CENTER);
		c.add(rst,BorderLayout.SOUTH);
		c.add(cfg,BorderLayout.NORTH);
		c.add(sty,BorderLayout.EAST);
		setVisible(true);
		setSize(50+BUTCOLUMN*BUTSIZE,50+BUTROW*BUTSIZE);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent e){
		int indexi=-1;
		int indexj=-1;
		for(int i=0;i<but.length;i++)
			for(int j=0;j<but[i].length;j++)
				if(but[i][j]==e.getSource()){
					indexi=i;
					indexj=j;
				}
		if(indexi!=-1&&indexj!=-1){
			if(determ==1){
				for(int i=0;i<5;i++){
					if((indexi+nx[i]<but.length)&&(indexi+nx[i]>=0)&&(indexj+ny[i]<but[indexi].length)&&(indexj+ny[i]>=0)){
						if(but[indexi+nx[i]][indexj+ny[i]].getBackground()==Color.green)
							but[indexi+nx[i]][indexj+ny[i]].setBackground(Color.yellow);
						else
							but[indexi+nx[i]][indexj+ny[i]].setBackground(Color.green);
					}
				}
			}
			else but[indexi][indexj].setVisible(false);
		}
		else if(e.getSource()==rst)
				for(int i=0;i<but.length;i++)
					for(int j=0;j<but[i].length;j++){
						but[i][j].setBackground(Color.green);
					}
			else if(e.getSource()==cfg){
				determ=0;
			}
				else 
					determ=1;
	}
	public static void main(String args[]){
	 ButtonGame bg=new ButtonGame();
	 bg.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
	}
}