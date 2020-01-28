package hu.flowacademy.musicstore.Model;

import javax.persistence.*;

@Entity
@Table(name = "albumtable")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long count;



    public Album() {
    }

    public Album(Long id, String title, Long count) {
        this.id = id;
        this.title = title;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
