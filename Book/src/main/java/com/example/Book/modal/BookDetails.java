package com.example.Book.modal;

public class BookDetails {
    private  int id;
    private String name;
    private String imageUrl;
    public  BookDetails(int id,String name,String imageUrl){
        this.id=id;
        this.name=name;
        this.imageUrl=imageUrl;


    }



    public void setId(int id){
        this.id=id;

    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String  getName(){
        return name;

    }

    public String getImageUrl() {
        return imageUrl;
    }

}
