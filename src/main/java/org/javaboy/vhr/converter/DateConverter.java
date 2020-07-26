package org.javaboy.vhr.converter;

import org.apache.poi.hssf.record.DVALRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: TongYaZhou
 * @create: 2020-07-26 19:05
 * Converter<String, Date>: 原数据类型为String，要转成Date类型
 **/
@Component
public class DateConverter implements Converter<String, Date> {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    @Override
    public Date convert(String source) {
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
