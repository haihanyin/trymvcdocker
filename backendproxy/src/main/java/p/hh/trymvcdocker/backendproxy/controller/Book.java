package p.hh.trymvcdocker.backendproxy.controller;

public class Book {

    private long id;

    private String name;

    public Book() {}

    public Book(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void decorateName() {
        this.name = "proxy_" + name;
    }

    @Override
    public String toString() {
        return "Book(id=" + id + ", name=" + name + ")";
    }
}
