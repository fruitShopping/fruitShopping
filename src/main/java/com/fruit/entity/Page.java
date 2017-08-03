package com.fruit.entity;

/**
 * Created by tao on 2014/12/11.
 */
public class Page {
    public static final int DEFAULT_SIZE = 10;
    private int currentPage = 0;
    private int size = DEFAULT_SIZE;
    private int begin;
//    private int total;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBegin(){
        return (this.currentPage - 1) * size;
    }

    public void setBegin(int begin){
       this.begin = begin;
    }

//    public int getBegin(){
//        return (this.currentPage - 1) * size + 1;
//    }

    public int getEnd(){
        return (this.currentPage) * size;
    }
}
