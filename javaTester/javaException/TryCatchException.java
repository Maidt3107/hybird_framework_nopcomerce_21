package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {

	public static void main(String[] args) {
		
		try {
			int array[] = new int[10];
			array[11] = 30 / 1;
		} catch ( ArithmeticException  e) {
		System.out.println("không thể chia cho 0");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" Index vượt ngoài độ dài của mảng");
		}
		try {
			FileOutputStream outputStream = new FileOutputStream("C://automationfc.jpg");
			outputStream.write(65);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
