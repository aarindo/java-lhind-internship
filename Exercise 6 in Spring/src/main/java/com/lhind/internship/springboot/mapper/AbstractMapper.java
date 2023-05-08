package com.lhind.internship.springboot.mapper;

public abstract class AbstractMapper<ENTITY,DTO> {

    public abstract DTO toDto(ENTITY entity);

}