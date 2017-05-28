package hu.unideb.inf.DAO;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "players")
@XmlAccessorType (XmlAccessType.FIELD)
public class Players {
	
    @XmlElement(name = "player")
    private List<Player> players = null;
 
    public List<Player> getPlayers() {
        return players;
    }
 
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
