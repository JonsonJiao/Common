import java.io.*;

public class Question1 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		try {
			FileWriter fw = new FileWriter("./src/a.txt", true);
			for (int i = 1; i <= 100; i++) {
				fw.write(i + "\r\n");
			}
			fw.close();
			System.out.println("写入文件成功");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
