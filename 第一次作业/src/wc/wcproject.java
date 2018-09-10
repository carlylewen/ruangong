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
	private static int spaceline;//空行
	private static int codeline;//代码行
	private static int noteline;//注释行
	private static JFileChooser chooser;
	private static int flag=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		command=" ";//存储用户命令
		while(true) {
			int flag1=0;
			System.out.println("請输入指令及路径：");
			Scanner s=new Scanner(System.in);//从键盘输入
			command=s.nextLine();//获取输入命令
			String[] split =command.split(" ");//分割命令
			int messlength=split.length;
			sparameter=new String[messlength-1];
			//获取命令参数
			for (int i=0; i<messlength-1;i++) {
				sparameter[i]=split[i];
				if(sparameter[i].equals("-s")) {
					flag1=1;
				}
				
			}
			//获取文件名
			filename =split[messlength-1];
			if(flag1==1) {
				
			}
			else {
				
			}
		}
		

	}
	//输出函数
	private static void output() {
		
	}
	

}
