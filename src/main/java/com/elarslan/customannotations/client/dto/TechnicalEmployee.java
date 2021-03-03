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

    public TechnicalEmployee(String name, Integer id, List<String> accessibleSources) {
        super(name, id);
        this.accessibleSources = new ArrayList<>(accessibleSources);
    }
}
