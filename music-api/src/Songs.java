import java.util.*;
public class Songs {
	ArrayList<Song> songList;
	
	public void addSong(Song song) {
		songList.add(song);
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}


}
