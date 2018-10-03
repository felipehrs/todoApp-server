package app.hrs.todoList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.GregorianCalendar;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private boolean status;
    private String description;
    private GregorianCalendar creationDate;
    private GregorianCalendar updateDate;
    private GregorianCalendar removeDate;
    private GregorianCalendar finishDate;

    public Task()
    {
        this.id = -1;
        this.title = "";
        this.status = false;
        this.description = "";
        this.creationDate = new GregorianCalendar();
    }

    public Task(int id, String title)
    {
        this.id = id;
        this.title = title;
        this.status = false;
        this.description = "";
        this.creationDate = new GregorianCalendar();
    }

    public Task(int id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.status = false;
        this.description = description;
        this.creationDate = new GregorianCalendar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    public GregorianCalendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(GregorianCalendar updateDate) {
        this.updateDate = updateDate;
    }

    public GregorianCalendar getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(GregorianCalendar removeDate) {
        this.removeDate = removeDate;
    }

    public GregorianCalendar getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(GregorianCalendar finishDate) {
        this.finishDate = finishDate;
    }
}
