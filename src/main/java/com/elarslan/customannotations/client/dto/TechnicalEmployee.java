package com.elarslan.customannotations.client.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalEmployee extends Employee {
    private List<String> accessibleSources;

    public TechnicalEmployee(String name, Integer id, Integer level, List<String> accessibleSources) {
        super(name, id, level);
        this.accessibleSources = new ArrayList<>(accessibleSources);
    }
}
