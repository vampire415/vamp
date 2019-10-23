
import java.io.FileWriter;

import java.io.IOException;

import java.util.Random;

import java.util.Scanner;

public class MathSum {

	public static void main(String[] args) throws Exception {

		//新建写入文件的对象

		FileWriter f = new FileWriter("E://result.txt");

		//建立随机数对象，选择进行运算的运算符、选择随机符号

		Random rm = new Random();

		char[] opera_all = { '*', '/', '+', '-' };

		char operachar;

		//要写入文件的字符，定义 m,n 两个运算数 ，c是m和n 运算操作的结果、规定出题数

		String write_file = "";

		int m = 0, n = 0, c = 0;

		Scanner sc=new Scanner(System.in);

		int mm=sc.nextInt();

		//每次产生随机数（从数组取运算符号）

		System.out.println("输入数据范围  ");

		Scanner ss=new Scanner(System.in);

		int nn=sc.nextInt();

		for (int i = 0; i < mm; i++) {

			

			int ope = rm.nextInt(4);

			operachar = opera_all[ope];

			m = (int) (Math.random() * nn);

			n = (int) (Math.random() * nn);

			if ('*' == operachar || '/' == operachar) {

				i--;

				continue;

			}

         //用switch语句运算符号判断 选择

			switch (operachar) {  

			case '+':

				c = m + n;

				break;

			case '-':

				c = m - n;

				break;

			case '*':

				c = m * n;

				break;

			case '/':

				//排除分母不能为0

				if (n == 0) {

					i--;

					continue;

				}

				c = m / n;

				break;

			}

			//排除超过100、负数的情况

			if (c >= 100 || c < 0) {

				i--;

				continue;

			}

             //将题以字符方式拼接 、并去掉重复的题

			String h = m + "" + operachar + n + "=";

             if (write_file.contains(h)) {

				i--;

				continue;

			}

             //写入文件操作

			write_file = write_file +"第"+(i+1)+"题："+h + " " + "\n";	

		}

		

		//写入文件、文件关闭

		f.write(write_file);

		f.close();

		System.out.println("在文件E:// result.txt");

	}

}