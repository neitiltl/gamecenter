package backend.gamecenter.domain;

public class Game {

    private Long id;
    private String name;
    private String publisher;
    private Integer year;
    private String description;

    public Game() {
    }

    public Game(Long id, String name, String publisher, Integer year, String description) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.year = year;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game [name=" + name + ", publisher=" + publisher + ", year=" + year + ", description=" + description
                + "]";
    }

}
