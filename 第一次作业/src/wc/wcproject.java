package wc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
			System.out.println(cline);
			System.out.println(cword);
			System.out.println(cchar);
			System.out.println(codeline);
			System.out.println(noteline);
			System.out.println(spaceline);
			System.out.print("lines");
			System.out.print("words");
			System.out.print("chars");
			System.out.print("codelines");
			System.out.print("notelines");
			System.out.print("spacelines");
		}
		else {
			for(int i=0;i<sparameter.length-1;i++) {
				if(sparameter.equals("-c")) {
					System.out.println(cchar);
					System.out.print("chars");
					
				}
				if(sparameter.equals("-l")) {
					System.out.println(cline);
					System.out.print("lines");
				}
				if(sparameter.equals("-w")) {
					System.out.println(cword);
					System.out.print("words");
				}
				if(sparameter.equals("-a")) {
					System.out.println(codeline);
					System.out.println(noteline);
					System.out.println(spaceline);
					System.out.print("codelines");
					System.out.print("notelines");
					System.out.print("spacelines");
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
				
				
				
				
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
		}
		else {
			System.out.println("failed!!");
		}
	}

}
