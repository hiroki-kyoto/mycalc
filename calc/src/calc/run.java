package calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class run {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File(args[0]);
		FileReader fr = new FileReader(file);
		BufferedReader  br = new BufferedReader(fr);
		File out = new File("out.txt");
		out.createNewFile();
		FileWriter fw = new FileWriter(out);
		
		String[] name = new String[5];
		double[] score1 = new double[5];
		double[] score2 = new double[5];
		double[] score3 = new double[5];
		double[] total = new double[5];
		
		int i = 5;
		while(i>0)
		{
			String line = br.readLine();
			System.out.println(line);
			String[] tmp = line.split(" ");
			name[5-i] = tmp[0];
			score3[5-i] = Double.parseDouble(tmp[1]);
			total[5-i] = Double.parseDouble(tmp[2]);
			// y = (w-0.5*z-0.2)*2
			// x = y+0.5 
			double rate = Math.random();
			rate = (int)(rate*10);
			rate = rate/10;
			double sign = Math.random()>0.4?1:-1;
			rate = sign*rate;
			score2[5-i] = (total[5-i]-0.5*score3[5-i]-rate*0.4)*2;
			score1[5-i] = score2[5-i]+rate;
			
			score1[5-i] = (int)(score1[5-i]*10)/10.0;
			score2[5-i] = (int)(score2[5-i]*10)/10.0;
			
			fw.write(name[5-i]+" "+score1[5-i]+" "+score2[5-i]+" "+score3[5-i]+" "+total[5-i]+" "+0.4*score1[5-i]+" "+0.1*score2[5-i]+"\r\n");
			--i;
		}
		br.close();
		fw.close();
	}

}
