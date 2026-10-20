package backend.gamecenter.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long platformId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platform")
    private List<Game> games;

    public Platform() {
    }

    public Platform(Long platformId, String name) {
        this.platformId = platformId;
        this.name = name;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Platform [platformId=" + platformId + ", name=" + name + "]";
    }

}
