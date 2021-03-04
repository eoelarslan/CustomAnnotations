package com.elarslan.customannotations.client.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer id;
    private Integer level;
}
