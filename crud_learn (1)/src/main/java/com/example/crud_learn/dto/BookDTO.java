package com.example.crud_learn.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String author;
    private Date date;
}
