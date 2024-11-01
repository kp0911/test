package tutor;
import java.util.ArrayList;

public class MusicPlayer {
	ArrayList<Music> musiclist;

	public MusicPlayer() {
		musiclist = new ArrayList<Music>();
		musiclist.add(new Music("HIP", "mamamoo", 16, "test.mp3"));
		musiclist.add(new Music("Hapjeong", "유산술", 30, "test2.mp3"));
	}

	int pos;

	// 반환을 musiclist로 반환함 > 출력 자료형을 맞춰줌
	public Music play() {
		return musiclist.get(pos);

	}

	public String stop() {
		return "노래를 중지합니다.";
	}

	public Music prePlay() {
		if (pos == 0) {
			return null;
		} else {
			pos--;
			return musiclist.get(pos);
		}

	}

	public Music nextPlay() {
		if (pos == musiclist.size() - 1) {
			return null;
		} else {
			pos++;
			return musiclist.get(pos);
		}
	}

}
