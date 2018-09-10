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
				digui();//-s
			}
			else {
				extend();//扩展功能
				output();//基础功能
			}
		}
		
	}
	//输出函数
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
	
	//递归文件函数
	private static void digui() {
		
	}
	
	//计算code、note、spaceline
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
				FileInputStream filein =new FileInputStream(file);//输入流读取文件
				InputStreamReader inputr=new InputStreamReader(filein,"UFT-8");
				BufferedReader bread =new BufferedReader(inputr);
				String line="";
				StringBuffer buffer =new StringBuffer();
				while((line=bread.readLine())!=null) {
					cline++;
					buffer.append(line);
					cchar+=line.length();
					
					//空行
					if(bread.readLine().equals("")) {
						spaceline++;
						continue;
					}
					//注释行
					int a=line.indexOf("/");
					int b=line.substring(a+1).indexOf("/");
					if(b==0) {
						noteline++;
						continue;
					}
					//代码行
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
