package com.example.prove05;


public class Scripture {

    private String book;
    private String chapter;
    private String verse;
    private String scriptureReference;


    public Scripture(String book, String chapter, String verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.scriptureReference = book + " " + chapter + ":" + verse;
    }


    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getScriptureReference() {
        return scriptureReference;
    }
}
