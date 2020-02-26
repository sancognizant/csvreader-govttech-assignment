package com.example.csvreader.Utils;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class CSVFILEPROCESSOR {

    private static final CsvMapper mapper = new CsvMapper();
    @Autowired
    static ResourceLoader resourceLoader;

    private CSVFILEPROCESSOR() {

    }

    private final static InputStream getResourceStream(String filename) throws IOException {
        return new ClassPathResource("salary.csv").getInputStream();
    }

    public final static <T> List<T> read(Class<T> tClass) throws IOException {
        CsvSchema csvSchema = mapper.schemaFor(tClass).withHeader().withColumnReordering(true);
        ObjectReader objectReader = mapper.readerFor(tClass).with(csvSchema);
        InputStream inputStream = getResourceStream("salary.csv");
        return objectReader.<T>readValues(inputStream).readAll();
    }


}
