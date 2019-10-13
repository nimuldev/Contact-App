package com.math.phone;

public class CallInformation {

    private int id;
    private String name,work,email,address,phone,nick,relation;

   private int image;

    public CallInformation(int id, String name, String work, String email, String address, String phone, String nick, String relation, int image) {
        this.id = id;
        this.name = name;
        this.work = work;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.nick = nick;
        this.relation = relation;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getNick() {
        return nick;
    }

    public String getRelation() {
        return relation;
    }

    public int getImage() {
        return image;
    }
}
