package com.example.demo;


import lombok.*;
import org.hibernate.envers.*;

@AllArgsConstructor
@Getter
public class Revision {
    private int id;
    private long timestamp;
    public static Revision parse(DefaultRevisionEntity imput) {
        return new Revision(
                imput.getId(),
                imput.getTimestamp()
        );
    }
}
