package backend.gamecenter.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long platformId;
    private String name;

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

    @Override
    public String toString() {
        return "Platform [platformId=" + platformId + ", name=" + name + "]";
    }

}
