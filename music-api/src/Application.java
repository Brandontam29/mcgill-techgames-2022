import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpServer;

class Application {
	 static Songs songs = new Songs();
	
	public static void main(String[] args) throws IOException {
		int serverPort = 3000;
		HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
		server.createContext("/api/hello", (exchange -> {
			String respText = "Hello!";
			exchange.sendResponseHeaders(200, respText.getBytes().length);
			OutputStream output = exchange.getResponseBody();
			output.write(respText.getBytes());
			output.flush();
			exchange.close();
		}));

		server.createContext("/api/newSong", (exchange -> {
			Map<String, String> params = getQueryMap(exchange.getRequestURI().getRawQuery());
			System.out.println(params);
			String name = params.get("name");
			String author = params.get("author");
			String genre = params.get("genre");

			Song song = new Song(name, author, genre);
			songs.addSong(song);
			
			String respText = song.toJson();
			exchange.sendResponseHeaders(200, respText.getBytes().length);
			OutputStream output = exchange.getResponseBody();
			output.write(respText.getBytes());
			output.flush();
			exchange.close();
		}));

		server.setExecutor(null); // creates a default executor
		server.start();
	}
    public static void printSongList(Playlist songList, OutputStream output){
        for (int i=0; i<songList.getSongList().size(); i++){
            output.write(songList.getSong(i).getBytes());
        }
    }
    
	public static Map<String, String> getQueryMap(String query) {
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<String, String>();

		for (String param : params) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
		}
		return map;
	}

}