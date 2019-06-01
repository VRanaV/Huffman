import java.io.FileReader; 

import java.io.*;
import java.util.*;
class T{
	char a;
	String c;
}

public class Reading {
	
 private Scanner x;
 private Scanner y;
 private Scanner z;
 public void OpenFile() {
	 try {
		 x=new Scanner(new File("Compression.txt"));
	 }
	 catch(Exception e) {
		 System.out.println("Error");
	 }
 }
 public String ReadFile() {
	 String m="";
	 while(x.hasNext()) {
		 String a=x.next();
		 m+=a;
		 //System.out.printf("%s",a);
	 }
	 return m;
 }
 public void CloseFile() {
	 x.close();
 }
 ////////////////////////////////////////////////////////////////////////////////////
 public void OpenFiler() {
	 try {
		 //FileReader y =new FileReader("Table.txt");
		 y=new Scanner(new File("Table.txt"));
	 }
	 catch(Exception e) {
		 System.out.println("Error");
	 }
 }
 public ArrayList<T> ReadFiler() {
	ArrayList<T>k=new ArrayList<T>();
	 y.useDelimiter(",");
	 while(y.hasNext()) {
		 T obj=new T();
			
		  String m =y.next();
		  char c=m.charAt(0);
		 String a=y.next();		
		 obj.a=c;
		 obj.c=a;
		 k.add(obj);
		  }
	 return k;
 }
 public void CloseFiler() {
	 y.close();
 }

 ///////////////////////////////////////////////////////////////////////////////////
  public void OpenFileAgain() {
	 try {
		 z=new Scanner(new File("StreamResult.txt"));
	 }
	 catch(Exception e) {
		 System.out.println("Error");
	 }
 }
 public String ReadFileAgain() {
	 String m="";
	 while(z.hasNext()) {
		 String a=z.next();
		 m+=a;
		 //System.out.printf("%s",a);
	 }
	 return m;
 }
 public void CloseFileAgain() {
	 z.close();
 }

}
