package backend.gamecenter.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    private String publisher;
    private Integer publishingYear;

    @Size(max = 750)
    private String description;

    @ManyToOne
    @JoinColumn(name = "platformId")
    private Platform platform;

    public Game() {
    }

    public Game(Long id, String name, String publisher, Integer publishingYear, String description, Platform platform) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.description = description;
        this.platform = platform;
    }

    public Game(String name, String publisher, Integer publishingYear, String description, Platform platform) {
        this.name = name;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.description = description;
        this.platform = platform;
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

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Game [id=" + id + ", name=" + name + ", publisher=" + publisher + ", publishingYear=" + publishingYear
                + ", description=" + description + ", platform=" + platform + "]";
    }

}
