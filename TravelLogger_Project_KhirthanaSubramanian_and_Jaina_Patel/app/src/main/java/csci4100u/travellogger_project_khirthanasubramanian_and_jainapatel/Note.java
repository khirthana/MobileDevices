/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    Note:

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;


import java.io.Serializable;

public class Note implements Serializable {
    String note_name;
    String note_content;
    public int id;

    public Note(){
        this.note_name=null;
        this.note_content=null;
    }

    public Note(String name,String content){
        super();
        this.note_name=name;
        this.note_content=content;
;
    }

    void setNote_name(String name){
        this.note_name=name;
    }

    void setNote_content(String content){
        this.note_content=content;
    }

    void setId(int id){this.id=id;}

    String getNote_name(){
        return note_name;
    }

    String getNote_content(){
        return note_content;
    }

    int getId(){ return id;}

}
