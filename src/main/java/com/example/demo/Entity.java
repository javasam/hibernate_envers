package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.*;
import org.hibernate.envers.*;

import javax.persistence.*;

@javax.persistence.Entity
@JsonSerialize
@JsonDeserialize
@Table(name = "test_table", schema = "public")
@Audited
@Data
public class Entity {

    @Id
    @Column
    @JsonProperty("id")
    private Long id;

    @Column
    @JsonProperty("name")
    private String name;
}
