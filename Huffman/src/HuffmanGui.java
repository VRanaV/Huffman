import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



public class HuffmanGui extends JFrame {
	
	HNode root=new HNode();
	private JPanel contentPane;
	private JTextField outcompress;
	private JTextField outdecompress;

	/**
	 * Launch the application.
	 */
	
	public static int getMinValue(ArrayList<HNode> a){
		  int minValue = a.get(0).n;
		  int p=0;
		  for(int i=1;i<a.size();i++){
		    if(a.get(i).n< minValue){
			  minValue = a.get(i).n;
			  p=i;
			}
		  }
		  return p;
		}
	
	public static void TraverseTree(HNode roott,String code) {
		//System.out.println("here");
		final Writing f= new Writing ();

		f.OpenFile2();
		
		if(roott.left == null && roott.right==null) {
			//System.out.println(roott.c+":"+code);
			f.AddRecord2(roott.c, code);
			f.CloseFile2();
		}
		
		if (roott.left != null)
			TraverseTree(roott.left,code+"0");
		
		if (roott.right != null)
		TraverseTree(roott.right,code+"1");
		
			
	}
	
	public static String Decode(HNode root,String in) {
		String out="";
		HNode curr=root;
		for(int y=0 ; y<in.length();y++) {
			if(in.charAt(y)=='0') {
				curr=curr.left;
			}else {
			 curr=curr.right;
			}
			if(curr.left==null &&curr.right==null) {
				out+=curr.c;
				curr=root;
			}
			
		}
		return out;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuffmanGui frame = new HuffmanGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HuffmanGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Compression");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Reading object2= new Reading ();
				object2.OpenFile();
				String k=object2.ReadFile();
				object2.CloseFile();
				char array[]=k.toCharArray();
				int freq[]= new int [128];
				ArrayList<HNode>nodes= new ArrayList<HNode>();
				int g=array.length;

				for(char i :array) {
					int c=i;
					freq[c]++;
				}
				for(int x=0 ; x<freq.length;x++) {
					if(freq[x]>0) {
					char d=(char)x;
					HNode y=new HNode();
					y.c=d;
					y.n=freq[x];
					y.left=null;
					y.right=null;
					nodes.add(y);
					//System.out.println(freq[x]+" "+d);
				}
					}
				while(nodes.size()>1) {

					HNode min1= new HNode();
					HNode min2 =new HNode();
					int pos1=0;
					int pos2=0;
					
					pos1=getMinValue(nodes);
					min1=nodes.get(pos1);
					nodes.remove(min1);
					pos2=getMinValue(nodes);
					min2=nodes.get(pos2);
					
					nodes.remove(min2);
				HNode sum=new HNode();

				sum.n=min1.n+min2.n;
				sum.c='-';
				sum.left=min1;
				sum.right=min2;
				root=sum;
				nodes.add(sum);

				}
				String out ="";
				TraverseTree(root,out);
				ArrayList<T>p=new ArrayList<T>();
				Reading j= new Reading ();
				j.OpenFiler();

				p=j.ReadFiler();
				j.CloseFiler();
				for(int jj=0 ; jj<p.size();jj++) {
					System.out.println(p.get(jj).a+" "+p.get(jj).c);
				}
				String stream="";

				for(char l :array) {
					for(int ju =0 ; ju<p.size(); ju++) {
					if(l==p.get(ju).a) {
						stream+=p.get(ju).c;
					}
				}
					
				}
				outcompress.setText(stream);
				
				Writing object3= new Writing ();
				object3.OpenFileAgain();
				object3.AddRecordAgain(stream);
				object3.CloseFileAgain();
				Reading object4= new Reading ();
				object4.OpenFileAgain();
				String use=object4.ReadFileAgain();
				object4.CloseFileAgain();
				

				
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setBounds(101, 29, 228, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decompression");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reading object4 = new Reading();
				object4.OpenFileAgain();
				
				String use=object4.ReadFileAgain();
				object4.CloseFileAgain();
				String finall=Decode(root,use);
				outdecompress.setText(finall);
				
			}
		});
		btnNewButton_1.setBackground(new Color(128, 0, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(205, 92, 92));
		btnNewButton_1.setBounds(101, 147, 228, 37);
		contentPane.add(btnNewButton_1);
		
		outcompress = new JTextField();
		outcompress.setBounds(65, 89, 302, 37);
		contentPane.add(outcompress);
		outcompress.setColumns(10);
		
		outdecompress = new JTextField();
		outdecompress.setBounds(65, 206, 302, 33);
		contentPane.add(outdecompress);
		outdecompress.setColumns(10);
	}
}
