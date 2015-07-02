import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

class Sound {
	FileInputStream file;
	BufferedInputStream buf;

	public Sound() {
		try {
			String musicPath = "music/flourish.mid";
			InputStream input = this.getClass().getResourceAsStream(musicPath);
			buf = new BufferedInputStream(input);
			System.out.println(buf);
			System.out.println("¿ªÊ¼²¥·Å");
			Applet.newAudioClip(this.getClass().getResource(musicPath)).play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
