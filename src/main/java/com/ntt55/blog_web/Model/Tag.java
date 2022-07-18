package com.ntt55.blog_web.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tid;

    @Column(name = "tag_name", unique = true)
    private String tag_name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private Collection<Post> posts;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long id) {
        this.tid = tid;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String role) {
        this.tag_name = tag_name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setUsers(Collection<Post> posts) {
        this.posts = posts;
    }
}
