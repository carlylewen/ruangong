package wc;

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
				
			}
			else {
				
			}
		}
		

	}
	//�������
	private static void output() {
		
	}
	

}
