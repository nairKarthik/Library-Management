package io.karthik.librarymanagement.Models;

import javax.persistence.*;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String subject;
    private String author_f_name;
    private String author_l_name;
    private int cost;
    private int quantity;
    @ManyToOne
    @JoinColumn
    private BookCategories bookCategory;
    @ManyToOne
    @JoinColumn
    private Users users;

    public Books() {
    }

    public Books(int id, String title, String subject,String author_f_name, String author_l_name, int cost, int quantity, BookCategories bookCategory, Users users) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.author_f_name = author_f_name;
        this.author_l_name = author_l_name;
        this.cost = cost;
        this.quantity = quantity;
        this.bookCategory = bookCategory;
        this.users = users;
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

    public String getAuthor_f_name() {
        return author_f_name;
    }

    public void setAuthor_f_name(String author_f_name) {
        this.author_f_name = author_f_name;
    }

    public String getAuthor_l_name() {
        return author_l_name;
    }

    public void setAuthor_l_name(String author_l_name) {
        this.author_l_name = author_l_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookCategories getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategories bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author_f_name='" + author_f_name + '\'' +
                ", author_l_name='" + author_l_name + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", bookCategory=" + bookCategory +
                ", users=" + users +
                '}';
    }
}
