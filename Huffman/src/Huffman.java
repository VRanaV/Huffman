import java.util.*;

import java.util.Comparator; 

import java.io.*;
class HNode{
	int n;
	char c;
	HNode left = null;
	HNode right = null;
}
public class Huffman {

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
	
	public static void main(String[] args) {  ////////////////main
		
		Scanner scan= new Scanner(System.in);
		String input= scan.nextLine();
		Writing object1=new Writing();
		object1.OpenFile();
		object1.AddRecord(input);
		object1.CloseFile();
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

HNode root=new HNode();

while(nodes.size()>1) {
	/*
for(int i=0 ; i< nodes.size();i++) {
	if(nodes.get(i).n<min1.n) {
		min1=nodes.get(i);
		pos1=i;
		}
	else if(nodes.get(i).n<min2.n) {
		min2=nodes.get(i);
	     pos2=i;
	}
	
}
nodes.remove(pos1);
nodes.remove(pos2);
*/

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
Writing object3= new Writing ();
object3.OpenFileAgain();
object3.AddRecordAgain(stream);
object3.CloseFileAgain();
Reading object4= new Reading ();
object4.OpenFileAgain();
String use=object4.ReadFileAgain();
object4.CloseFileAgain();
String finall=Decode(root,use);
System.out.println(finall);
		}
	}

