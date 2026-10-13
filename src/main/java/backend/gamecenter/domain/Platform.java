package backend.gamecenter.domain;

public class Platform {

    private String name;

    public Platform() {
    }

    public Platform(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Platform [name=" + name + "]";
    }

}
