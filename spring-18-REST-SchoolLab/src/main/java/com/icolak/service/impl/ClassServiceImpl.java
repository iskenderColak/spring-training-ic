package com.icolak.service.impl;

import com.icolak.dto.ClassDTO;
import com.icolak.entity.Class;
import com.icolak.util.MapperUtil;
import com.icolak.repository.ClassRepository;
import com.icolak.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final MapperUtil mapperUtil;

    public ClassServiceImpl(ClassRepository classRepository, MapperUtil mapperUtil) {
        this.classRepository = classRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ClassDTO> findAll() {
        return classRepository.findAll()
                .stream()
                .map(theClass -> mapperUtil.convert(theClass, new ClassDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ClassDTO findById(Long id) throws Exception {
        Class foundClass = classRepository.findById(id)
                .orElseThrow(() -> new Exception("No Class Found!"));
        return mapperUtil.convert(foundClass, new ClassDTO());
    }

}