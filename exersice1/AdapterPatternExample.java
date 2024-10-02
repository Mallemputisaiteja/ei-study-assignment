interface MediaPlayer {
    void play(String audioType, String fileName);
}

class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else {
            System.out.println("Invalid media format");
        }
    }
}

interface AdvancedMediaPlayer {
    void playMp4(String fileName);
    void playVlc(String fileName);
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter("mp4");
        player.play("mp4", "song.mp4");
    }
}
