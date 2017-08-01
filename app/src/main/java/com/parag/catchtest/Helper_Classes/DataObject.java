package com.parag.catchtest.Helper_Classes;

/**
 * Created by parag on 1/08/2017.
 */

public class DataObject {

    private String title;
    private String subTitle;
    private int id;
    private String content;

    public DataObject(String text1, String text2, int id1, String text3 ){
        title = text1;
        subTitle = text2;
        id = id1;
        content = text3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mText1) {
        this.title = mText1;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String mText2) {
        this.subTitle = mText2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String mText3) {
        this.content = mText3;
    }

    public int getId() {
        return id;
    }

    public void setId(int mId) {
        this.id = mId;
    }
}
