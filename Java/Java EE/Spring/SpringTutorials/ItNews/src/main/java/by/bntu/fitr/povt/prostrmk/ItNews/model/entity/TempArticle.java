package by.bntu.fitr.povt.prostrmk.ItNews.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "OfferArticles")
public class TempArticle implements IArticles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;

    @Column(name = "userName")
    private String userName;

    @Column(name = "pathToFile")
    private String pathToFile;

    public TempArticle() {
    }

    public TempArticle(String title, String content, String type, String userName, String pathToFile) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.userName = userName;
        this.pathToFile = pathToFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("TempArticle{" + "id=").append(id).append(", title='").append(title).append('\'').append(", content='").append(content).append('\'').append(", type='").append(type).append('\'').append(", userName='").append(userName).append('\'').append(", pathToFile='").append(pathToFile).append('\'').append('}').toString();
    }
}
