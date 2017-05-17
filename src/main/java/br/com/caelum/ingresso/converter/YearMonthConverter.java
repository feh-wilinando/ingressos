package br.com.caelum.ingresso.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Created by matheusbrandino on 5/17/17.
 */
public class YearMonthConverter implements Converter<String, YearMonth> {

    @Override
    public YearMonth convert(String text) {
        return YearMonth.parse(text, DateTimeFormatter.ofPattern("MM/yyyy"));
    }
}
