package io.karthik.librarymanagement.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int catId;
    private String catName;
    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private List<Books> books;

    public BookCategories() {
    }

    public BookCategories(int catId, String catName, List<Books> books) {
        this.catId = catId;
        this.catName = catName;
        this.books = books;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookCategories{" +
                "cat_id=" + catId +
                ", cat_name='" + catName + '\'' +
                ", books=" + books +
                '}';
    }
}
