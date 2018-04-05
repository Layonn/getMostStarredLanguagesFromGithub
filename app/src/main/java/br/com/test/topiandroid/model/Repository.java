package br.com.test.topiandroid.model;

public class Repository {
    private String fullName;
    private int numberOfStars;
    private int numberOfForks;

    public Repository(String fullName, int numberOfStars, int numberOfForks) {
        this.fullName = fullName;
        this.numberOfStars = numberOfStars;
        this.numberOfForks = numberOfForks;
    }

    public String getFullName() {
        return fullName;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public int getNumberOfForks() {
        return numberOfForks;
    }

}
