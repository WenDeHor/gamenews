package com.silkpath.gamenews.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Message.ALL_SORTED, query = "SELECT m FROM Message m WHERE m.user.id=:userId ORDER BY m.id DESC"),
        @NamedQuery(name = Message.DELETE, query = "DELETE FROM Message m WHERE m.id=:id AND m.user.id=:userId"),
})
@Entity
@Table(name = "messages", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"}, name = "meals_unique_user_datetime_idx")})
public class Message extends IdEntity {
    public static final String ALL_SORTED = "Message.getAll";
    public static final String DELETE = "Message.delete";

    @Column(name = "text", nullable = false)
    @NotBlank
    @Size(min = 2, max = 200)
    String text;

    @Column(name = "like")
    @Range(max = 5000)
    int likecount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Message() {
    }

//    public Message(String text, int likecount) {
//        this(null, text, likecount);
//    }

    public Message(Integer id, String text, int likecount) {
        super(id);
        this.text = text;
        this.likecount = likecount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", like=" + likecount +
                ", user=" + user +
                ", id=" + id +
                '}';
    }
}
