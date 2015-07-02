import java.io.*;

public class Question2 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			FileWriter fw = new FileWriter("src/b.txt", true);
			BufferedReader br = new BufferedReader(new FileReader("src/a.txt"));
			String result = br.readLine();
			System.out.println("读取文件的内容如下：");
			int readValue = 0;
			while (result != null) {
				System.out.println(result);
				readValue = Integer.valueOf(result);
				fw.write(readValue * readValue + "\t" + Math.sqrt(readValue)
						+ "\r\n");
				result = br.readLine();

			}
			System.out.println("写入文件成功");
			fw.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}