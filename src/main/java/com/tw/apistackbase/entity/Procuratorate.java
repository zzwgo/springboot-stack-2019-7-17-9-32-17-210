package com.tw.apistackbase.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(unique = true,length = 50)
    @NotNull
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Prosecutor> prosecutors;
    public Procuratorate(@Length(min = 0, max = 50) @NotNull String name) {
        this.name = name;
    }

    public List<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(List<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }

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
}
