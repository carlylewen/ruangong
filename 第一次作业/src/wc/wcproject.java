package wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class wcproject {

	private static String command=" ";
	private static String[] sparameter;
	private static String filename;
	private static int cline;
	private static int cchar;
	private static int cword;
	private static int spaceline;//����
	private static int codeline;//������
	private static int noteline;//ע����
	private static JFileChooser chooser;
	private static int flag=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		command=" ";//�洢�û�����
		while(true) {
			int flag1=0;
			System.out.println("Ո����ָ�·����");
			Scanner s=new Scanner(System.in);//�Ӽ�������
			command=s.nextLine();//��ȡ��������
			String[] split =command.split(" ");//�ָ�����
			int messlength=split.length;
			sparameter=new String[messlength-1];
			//��ȡ�������
			for (int i=0; i<messlength-1;i++) {
				sparameter[i]=split[i];
				if(sparameter[i].equals("-s")) {
					flag1=1;
				}
				
			}
			//��ȡ�ļ���
			filename =split[messlength-1];
			if(flag1==1) {
				digui();//-s
			}
			else {
				extend();//��չ����
				output();//��������
			}
		}
		
	}
	//�������
	private static void output() {
		if(flag==1) {
			System.out.println("lines:"+cline);
			System.out.print("words:"+cword);
			System.out.print("chars:"+cchar);
			System.out.print("codelines:"+codeline);
			System.out.print("notelines:"+noteline);
			System.out.print("spacelines:"+spaceline);
		}
		else {
			for(int i=0;i<sparameter.length-1;i++) {
				if(sparameter.equals("-c")) {
					System.out.print("chars:"+cchar);
					
				}
				if(sparameter.equals("-l")) {
					System.out.println("lines:"+cline);
				}
				if(sparameter.equals("-w")) {
					System.out.print("words:"+cword);
				}
				if(sparameter.equals("-a")) {
					System.out.print("codelines:"+codeline);
					System.out.print("notelines:"+noteline);
					System.out.print("spacelines:"+spaceline);
				}
			}
		}
		System.out.println("");
	}
	
	//�ݹ��ļ�����
	private static void digui() {
		
	}
	
	//����code��note��spaceline
	private static void extend() {
		cchar=0;
		cword=0;
		cline=0;
		spaceline=0;
		codeline=0;
		noteline=0;
		File file =new File(filename);
		if(file.exists()) {
			try {
				FileInputStream filein =new FileInputStream(file);//��������ȡ�ļ�
				InputStreamReader inputr=new InputStreamReader(filein,"UFT-8");
				BufferedReader bread =new BufferedReader(inputr);
				String line="";
				StringBuffer buffer =new StringBuffer();
				while((line=bread.readLine())!=null) {
					cline++;
					buffer.append(line);
					cchar+=line.length();
					
					//����
					if(bread.readLine().equals("")) {
						spaceline++;
						continue;
					}
					//ע����
					int a=line.indexOf("/");
					int b=line.substring(a+1).indexOf("/");
					if(b==0) {
						noteline++;
						continue;
					}
					//������
					codeline++;
					
				}
				
				
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
		}
		else {
			System.out.println("failed!!");
		}
	}

}
