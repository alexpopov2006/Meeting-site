package com.meetingsite.entity;
public class Profile {
    User user;
    String gender;
    String birthDate; // Упрощаем LocalDate до String
    String aboutMe;
    Photo[] photos; // Упрощаем List<Photo> до массива

    public Profile(User user) {
        this.user = user;
        this.photos = new Photo[0]; // Пустой массив по умолчанию
    }
}