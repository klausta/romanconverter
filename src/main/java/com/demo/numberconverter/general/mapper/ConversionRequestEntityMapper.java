package com.demo.numberconverter.general.mapper;

import com.demo.numberconverter.general.entity.ConversionRequestDao;
import com.demo.numberconverter.general.entity.ConversionRequestDto;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

@Component
public class ConversionRequestEntityMapper implements EntityMapper<ConversionRequestDao, ConversionRequestDto> {

    @Override
    public ConversionRequestDto mapToDto(ConversionRequestDao dao) {
        ConversionRequestDto dto = new ConversionRequestDto();
        dto.setId(dao.getId());
        dto.setInput(dao.getInput());
        dto.setOutput(dao.getOutput());
        dto.setConversionType(dao.getConversionType());
        dto.setRequestDateTime(dao.getRequestDateTime().toLocalDateTime());
        return dto;
    }

    @Override
    public ConversionRequestDao mapToDao(ConversionRequestDto dto) {
        ConversionRequestDao dao = new ConversionRequestDao();
        dao.setId(dto.getId());
        dao.setInput(dto.getInput().toString());
        dao.setOutput(dto.getOutput().toString());
        dao.setConversionType(dto.getConversionType());
        return dao;
    }
}
