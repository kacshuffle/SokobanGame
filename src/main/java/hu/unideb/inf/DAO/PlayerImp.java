package hu.unideb.inf.DAO;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class PlayerImp {
	private static JAXBContext jaxbContext;
	private static File file;
	private static Unmarshaller unmarshaller;
	private static Players players = new Players();
	private static Marshaller jaxbMarshaller;
	
	static {
		try {
			jaxbContext = JAXBContext.newInstance(Players.class);

			file = new File("HighScores.xml");
			if (file.exists()) {
				unmarshaller = jaxbContext.createUnmarshaller();
				players = (Players) unmarshaller.unmarshal(file);
			} else {
				players.setPlayers(new ArrayList<Player>());
			}
			
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
		} catch(JAXBException e){
			e.printStackTrace();
		}
	}

	public static void AddToHighScore(int celban, int lepes, LocalDateTime datum, String nev) {
		Player player = new Player();
		player.setCelban(celban);
		player.setNev(nev);
		player.setDatum(datum.toString());
		player.setLepes(lepes);
		
		players.getPlayers().add(player);
		try {
			jaxbMarshaller.marshal(players, file);
			jaxbMarshaller.marshal(players, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
}
