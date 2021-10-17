package com.demo.numberconverter.general.repository;

import com.demo.numberconverter.general.entity.ConversionRequestDao;
import org.springframework.data.repository.Repository;

public interface ConversionRequestRepository extends Repository<ConversionRequestDao, Long> {

    ConversionRequestDao save(ConversionRequestDao entity);
}
