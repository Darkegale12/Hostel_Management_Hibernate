package com.hostel.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class hostel_room_database {  

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User_Login_Entity user;

    private String room_change_application;
    private String room_allocated;
    private int roommate_no;
    private long fees_payment;
    private String leave_application;
    private String service_request;
    private String branch_name;

    public hostel_room_database() {}

    public hostel_room_database(int id, User_Login_Entity user, String room_change_application,
                                 String room_allocated, int roommate_no, long fees_payment,
                                 String leave_application, String service_request,
                                 String branch_name) {
        this.id = id;
        this.user = user;
        this.room_change_application = room_change_application;
        this.room_allocated = room_allocated;
        this.roommate_no = roommate_no;
        this.fees_payment = fees_payment;
        this.leave_application = leave_application;
        this.service_request = service_request;
        this.branch_name = branch_name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User_Login_Entity getUser() { return user; }
    public void setUser(User_Login_Entity user) { this.user = user; }

    public String getRoom_change_application() { return room_change_application; }
    public void setRoom_change_application(String room_change_application) {
        this.room_change_application = room_change_application;
    }

    public String getRoom_allocated() { return room_allocated; }
    public void setRoom_allocated(String room_allocated) { this.room_allocated = room_allocated; }

    public int getRoommate_no() { return roommate_no; }
    public void setRoommate_no(int roommate_no) { this.roommate_no = roommate_no; }

    public long getFees_payment() { return fees_payment; }
    public void setFees_payment(long fees_payment) { this.fees_payment = fees_payment; }

    public String getLeave_application() { return leave_application; }
    public void setLeave_application(String leave_application) { this.leave_application = leave_application; }

    public String getService_request() { return service_request; }
    public void setService_request(String service_request) { this.service_request = service_request; }

    public String getBranch_name() { return branch_name; }
    public void setBranch_name(String branch_name) { this.branch_name = branch_name; }

    @Override
    public String toString() {
        return "hostel_room_database [id=" + id + ", user=" + user.getUsername()
               + ", room_change_application=" + room_change_application
               + ", room_allocated=" + room_allocated + ", roommate_no=" + roommate_no
               + ", fees_payment=" + fees_payment + ", leave_application=" + leave_application
               + ", service_request=" + service_request + ", branch_name=" + branch_name + "]";
    }
}
