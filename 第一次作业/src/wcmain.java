import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class wcmain {

	public static int cword=0;//����
	public static int cline=1;//����
	public static int cchar=0;//�ַ���
	public static ArrayList<String> file =new ArrayList<String>();//�ļ�
	public static String out="result.txt";//����ļ����ļ���
	public static int space=0,anno=0,codeline=0;//���У�ע���У�������
	
	public static void init() {
		cword=1;
		cline=1;
		cchar=0;
		space=0;
		anno=0;
		codeline=0;
		
	}
	
	public static void statistical(String file,int []use) throws IOException
	{
		int n=0;
		String ff=new String("src/"+file);
		InputStream f=new FileInputStream(file);
		boolean lastnowhile=false;
		boolean lastword=false;
		String wspace="\t\n\r";
		if(use[3]==1) {
			StringBuilder list =new StringBuilder();
			ArrayList<String>stop=new ArrayList<String>();
			while((n=f.read())!=-1)
			{
				cchar++;
				if(n=='\n') {
					cline++;
					cchar=cchar-2;
				}
				if(wspace.indexOf(n)==-1) {
					list.append((char)n);
				}
				if(wspace.indexOf(n)!=-1) {
					if(lastnowhile) {
						cword++;
						for(int i=0;i<stop.size();i++) {
							if(list.toString().equals(stop.get(i))) 
								cword--;
						}
							list.delete(0, list.length());
						}
						lastnowhile=false;
						lastword=true;
					}
					else {
						lastnowhile=true;
						lastword=false;
					}
				}
				if(!lastword) {
					for(int i=0;i<stop.size();i++) {
						if(list.toString().equals(stop.get(i)))
							cword--;
					}
				}
			}
		else {
			
		}
		
		}
			
			
		
	
	
	
	
	public static void extendsion() {//ע�ͣ��ո񣬴����м���
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
