/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;


public class MyWish {

    public String title;
    public int status;
    public int id;

    public MyWish (){
        this.title = null;
        this.status = 0;
    }

    public MyWish (String title, int status){
        super();
        this.title = title;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}