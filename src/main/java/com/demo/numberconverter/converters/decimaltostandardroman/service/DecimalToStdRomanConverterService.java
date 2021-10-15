package com.demo.numberconverter.converters.decimaltostandardroman.service;

import com.demo.numberconverter.converters.decimaltostandardroman.entity.ValidDecimalToStdRomanRequest;
import com.demo.numberconverter.general.service.ConverterService;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("decimaltostdroman")
public class DecimalToStdRomanConverterService extends ConverterService {

    @Override
    protected Class getValidationGroup() {
        return ValidDecimalToStdRomanRequest.class;
    }

    @Override
    protected Class getInputType() {
        return Integer.class;
    }

    @Override
    public Object convert(Object input) {
        Integer decimal = (Integer) input;
        if (decimal == null) {
            return EMPTY_RESULT;
        }

        int l = map.floorKey(decimal);
        if (decimal == l) {
            return map.get(decimal);
        }
        return map.get(l) + convert(decimal - l);
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

}
