package pl.simo333.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class Hero implements Comparable<Hero>, Serializable {
    private String name;
    private Long power;
    private LocalDate dateOfBirth;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Hero() {
    }

    public Hero(String name, Long power, LocalDate dateOfBirth, String phone) {
        this.name = name;
        this.power = power;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

    public int compareTo(Hero that) {
        return Comparator.comparing(Hero::getPower, Comparator
                .nullsFirst(Long::compare)).compare(this, that);
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                '}';
    }
}
