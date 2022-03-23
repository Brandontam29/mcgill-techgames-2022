import java.util.ArrayList;

public class Playlist {
	private String listName = "";
	private ArrayList<Song> songList = new ArrayList<>();

	public Playlist(String listName, ArrayList<Song> songList) {
		this.listName = listName;
		this.songList = songList;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public String getListName() {
		return listName;
	}

	public Song getSong(int index) {
		return songList.get(index);
	}

	public void removeSong(String name) {
		for (int i = 0; i < this.songList.size(); i++) {
			if (songList.get(i).getName().equals(name)) {
				songList.remove(i);
			}
		}
	}

}