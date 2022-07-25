package com.ntt55.blog_web.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long lid;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "likes")
    private Collection<Post> posts;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "likes")
    private Collection<User> users;



    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }


    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
