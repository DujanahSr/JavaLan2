package com.jl.per1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleDto {
    private int id;
    private String name;
    private String code;
    private String description;
    private boolean status;
}
