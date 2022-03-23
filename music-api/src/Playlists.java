import java.util.ArrayList;

public class Playlists {
	ArrayList<Song> songList;
	
	public void addSong(Song song) {
		songList.add(song);
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

}
