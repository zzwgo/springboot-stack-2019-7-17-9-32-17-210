package com.tw.apistackbase.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CriminalCaseDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Length(min = 0,max = 255)
    @NotNull
    private String objective;
    @Length(min = 0,max = 255)
    @NotNull
    private String subjective;

    public String getId() {
        return id;
    }

    public CriminalCaseDetail() {
    }

    public CriminalCaseDetail(@Length(min = 0, max = 255) @NotNull String objective, @Length(min = 0, max = 255) @NotNull String subjective) {
        this.objective = objective;
        this.subjective = subjective;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getSubjective() {
        return subjective;
    }

    public void setSubjective(String subjective) {
        this.subjective = subjective;
    }
}
