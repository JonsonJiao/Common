import java.io.*;

public class Question2 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			FileWriter fw = new FileWriter("src/b.txt", true);
			BufferedReader br = new BufferedReader(new FileReader("src/a.txt"));
			String result = br.readLine();
			System.out.println("��ȡ�ļ����������£�");
			int readValue = 0;
			while (result != null) {
				System.out.println(result);
				readValue = Integer.valueOf(result);
				fw.write(readValue * readValue + "\t" + Math.sqrt(readValue)
						+ "\r\n");
				result = br.readLine();

			}
			System.out.println("д���ļ��ɹ�");
			fw.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}