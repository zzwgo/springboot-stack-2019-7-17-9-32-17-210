package com.tw.apistackbase.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CriminalCase {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;
    private Long time;

    @Length(min = 0,max = 255)
    @NotNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private CriminalCaseDetail criminalCaseDetail;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Procuratorate procuratorate;

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public CriminalCase() {
    }

    public CriminalCase(Long time, @Length(min = 0, max = 255) @NotNull String name) {
        this.time = time;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CriminalCaseDetail getCriminalCaseDetail() {
        return criminalCaseDetail;
    }

    public void setCriminalCaseDetail(CriminalCaseDetail criminalCaseDetail) {
        this.criminalCaseDetail = criminalCaseDetail;
    }

}
