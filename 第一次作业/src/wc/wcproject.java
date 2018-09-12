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

	private static String command = " ";
	private static String[] sparameter;
	private static String filename;
	private static int cline;
	private static int cchar;
	private static int cword;
	private static int spaceline;// ����
	private static int codeline;// ������
	private static int noteline;// ע����
	private static JFileChooser chooser;
	private static int flag = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		command = " ";// �洢�û�����
		while (true) {
			int flag1 = 0;
			System.out.println("Ո����ָ�·����");
			Scanner s = new Scanner(System.in);// �Ӽ�������
			command = s.nextLine();// ��ȡ��������
			// ͼ�λ�
			if (command.equals("-x")) {
				tuxing();
				continue;
			}
			String[] split = command.split(" ");// �ָ�����
			int messlength = split.length;
			sparameter = new String[messlength - 1];
			// ��ȡ�������
			for (int i = 0; i < messlength - 1; i++) {
				sparameter[i] = split[i];

			}
			// ��ȡ�ļ���
			filename = split[messlength - 1];

			extend();// ͳ�ƹ���
			output();// ���

		}

	}

	private static void tuxing() {
		// TODO Auto-generated method stub
		flag = 1;
		chooser = new JFileChooser();
		int value = chooser.showOpenDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			File ff = chooser.getSelectedFile();
			filename = ff.getAbsolutePath();
			extend();
			output();
		}
	}

	// �������
	private static void output() {
		if (flag == 1) {
			System.out.println("�ַ�����"+cchar);
			System.out.println("������"+cline);
			System.out.println("��������"+cword);
			System.out.println("���У�"+spaceline);

			System.out.println("�����У�"+codeline);
			System.out.println("ע���У�"+noteline);
		} else {
			for (int i = 0; i < sparameter.length; i++) {
				if (sparameter[i].equals("-c")) {

					System.out.println("�ַ�����"+cchar);

				}
				if (sparameter[i].equals("-l")) {
		
					System.out.println("������"+cline);
				}
				if (sparameter[i].equals("-w")) {
					System.out.println("��������"+cword);
				}
				if (sparameter[i].equals("-a")) {
					System.out.println("���У�"+spaceline);

					System.out.println("�����У�"+codeline);
					System.out.println("ע���У�"+noteline);
				}
			}
		}
		System.out.println("");
	}

	// ����code��note��spaceline
	private static void extend() {
		cchar = 0;
		cword = 0;
		cline = 0;
		spaceline = 0;
		codeline = 0;
		noteline = 0;
		boolean q=false;
		File file = new File(filename);
		if (file.exists()) {
			try {
				FileInputStream filein = new FileInputStream(file);// ��������ȡ�ļ�
				
				BufferedReader bread = new BufferedReader(new InputStreamReader(filein));
				String line = "";
				StringBuffer buffer = new StringBuffer();
				while ((line = bread.readLine()) != null) {
					cline++;
					buffer.append(line);
					cchar += line.length();
					line=line.trim();

					// ����,ע���У�������
					String begin="\\s*/\\*.*";
					String end =".*\\*/\\s*";
					String x= "//.*";
					String space="\\s*";
					if(line.matches(begin)&&line.matches(end)) {
						++noteline;
					}
					if(line.matches(begin)) {
						++noteline;
						q=true;
					}
					else if(line.matches(end)) {
						++noteline;
						q=false;
					}
					else if(line.matches(space)) {
						++spaceline;
					}
					else if(line.matches(x)) {
						++noteline;
					}
					else if(q) {
						++noteline;
					}
					else {
						++codeline;
					}
					


				}
				cword = buffer.toString().split("\\s+").length;
				bread.close();
				
				filein.close();

			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("failed!!");
		}
	}

}
