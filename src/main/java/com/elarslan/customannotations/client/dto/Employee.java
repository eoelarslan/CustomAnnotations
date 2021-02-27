package com.elarslan.customannotations.client.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer id;
}