package com.demo.numberconverter.general.mapper;

import com.demo.numberconverter.general.entity.BaseDao;
import com.demo.numberconverter.general.entity.BaseDto;

public interface EntityMapper<T extends BaseDao, S extends BaseDto> {

    S mapToDto(T dto);

    T mapToDao(S dao);

}
