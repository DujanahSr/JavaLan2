package com.jl.per1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jl.per1.dto.SampleDto;
import com.jl.per1.dto.UpdateSampleDto;
import com.jl.per1.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {

    // private final SampleService sampleService;
    // @Autowired
    // SampleController(SampleService sampleService) {
    // this.sampleService = sampleService;
    // }
    @Autowired
    SampleService sampleService;

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok().body(sampleService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody SampleDto dto) {
        sampleService.create(dto);
        return ResponseEntity.ok().body("Data berhasil ditambah");
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@PathVariable int id,
            @RequestBody UpdateSampleDto dto) {
        sampleService.update(id, dto);
        return ResponseEntity.ok().body("Data berhasil diubah");
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        sampleService.delete(id);
        return ResponseEntity.ok().body("Data berhasil dihapus");
    }
}