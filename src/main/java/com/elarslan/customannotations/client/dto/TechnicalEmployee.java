package com.elarslan.customannotations.client.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalEmployee extends Employee{
    private List<String> accessibleSoftwares;

    public TechnicalEmployee(String name, Integer id, List<String> accessibleSoftwares){
        super(name, id);
        this.accessibleSoftwares = new ArrayList<>(accessibleSoftwares);
    }
}
