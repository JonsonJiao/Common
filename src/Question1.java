import java.io.*;

public class Question1 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		try {
			FileWriter fw = new FileWriter("./src/a.txt", true);
			for (int i = 1; i <= 100; i++) {
				fw.write(i + "\r\n");
			}
			fw.close();
			System.out.println("д���ļ��ɹ�");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
