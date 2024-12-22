package com.jl.per1.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jl.per1.dto.SampleDto;
import com.jl.per1.dto.UpdateSampleDto;
import com.jl.per1.model.Sample;

public class SampleServiceImpl implements SampleService {

    List<Sample> samples = new ArrayList<>();

    @Override
    public List<SampleDto> findAll() {
        return samples.stream()
                .map(this::mapToSampleDto)
                .toList();
    }

    @Override
    public void create(SampleDto dto) {
        samples.add(mapToSample(dto));
    }

    @Override
    public void update(int id, UpdateSampleDto dto) {
        samples = samples
                .stream()
                .filter(sample -> sample.getId() == id)
                .map(sample -> {
                    Sample updated = new Sample();
                    updated.setId(id);
                    updated.setName(dto.getName());
                    updated.setCode(dto.getCode());
                    updated.setDescription(dto.getDescription());
                    updated.setStatus(dto.isStatus());
                    updated.setUpdateDate(LocalDate.now());
                    return updated;
                }).toList();
    }

    @Override
    public void delete(int id) {
        Optional<Sample> sample = samples
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst();
        sample.ifPresent(value -> samples.remove(value));
    }

    public SampleDto mapToSampleDto(Sample sample) {
        return SampleDto.builder()
                .id(sample.getId())
                .name(sample.getName())
                .code(sample.getCode())
                .description(sample.getDescription())
                .status(sample.isStatus())
                .build();
    }

    public Sample mapToSample(SampleDto dto) {
        return Sample.builder()
                .id(dto.getId())
                .name(dto.getName())
                .code(dto.getCode())
                .description(dto.getDescription())
                .status(dto.isStatus())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .build();
    }

}