package com.jl.per1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.per1.dto.SampleDto;
import com.jl.per1.dto.UpdateSampleDto;

@Service
public interface SampleService {
    List<SampleDto> findAll();
    void create(SampleDto dto);
    void update(int id,UpdateSampleDto dto);
    void delete(int id);
}