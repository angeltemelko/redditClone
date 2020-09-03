package com.angel.demo.model;

import lombok.Data;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Data
public class Role {

    @Id @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> user;

    public Role(String name)
    {
        this.name = name;
    }

}
