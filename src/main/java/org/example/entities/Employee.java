package org.example.entities;

import jakarta.persistence.*;
import org.example.entities.generators.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GenericGenerator(name = "UUIDGenerator",type = UUIDGenerator.class)
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(length = 500)
    private String id;

    private String name;
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}