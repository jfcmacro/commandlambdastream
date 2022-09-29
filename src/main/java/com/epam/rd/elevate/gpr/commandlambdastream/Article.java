package com.epam.rd.elevate.gpr.commandlambdastream;

public class Article {
    private String name;
    private String description;

    public Article(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Article: " + name + " " + description;
    }
}
