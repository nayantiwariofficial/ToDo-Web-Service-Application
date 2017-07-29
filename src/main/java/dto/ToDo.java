package dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.NaturalId;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by nayantiwari on 7/10/17.
 */
@Entity
@Table(name = "to_do")
public class ToDo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private long id;

    @Column(name = "todo_order")
    @JsonProperty("order")
    private int order;

    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "date")
    @JsonIgnore
    private LocalDate date;

    public ToDo() {
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", order=" + order +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss ZZZ")
    public Date getNormalDate() {
        try {
            return Date.from(getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (NullPointerException e) {
            System.out.println("Date is null");
            return null;
        }
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
