package com.ntt55.blog_web.Model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "action_id")
    private Long id;

    private String action;
    private String path;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "actions")
    private Collection<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
