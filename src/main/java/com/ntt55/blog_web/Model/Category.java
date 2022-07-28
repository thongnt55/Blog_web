package com.ntt55.blog_web.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long cateid;

    @Column(name = "category_name", unique = true)
    private String category_name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Collection<Post> posts;

    public Long getCid() {
        return cateid;
    }

    public Long getCateid() {
        return cateid;
    }

    public void setCateid(Long cateid) {
        this.cateid = cateid;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public void setId(Long id) {
        this.cateid = cateid;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String role) {
        this.category_name = category_name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setUsers(Collection<Post> posts) {
        this.posts = posts;
    }
}
