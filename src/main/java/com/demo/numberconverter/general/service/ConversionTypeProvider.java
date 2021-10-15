package com.demo.numberconverter.general.service;

import com.demo.numberconverter.general.entity.ConversionType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class ConversionTypeProvider {

    public Map<Integer, String> getConversionTypes() {
        HashMap<Integer, String> map = new HashMap<>();
        for (ConversionType type : ConversionType.values()) {
            map.put(type.getId(), type.getDescription());
        }
        return map;
    }

}
