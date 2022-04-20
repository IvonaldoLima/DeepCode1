package com.ipl.aula6bancodedadosroom.data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Converter {

    // TODO: 20/04/2022 Adicionar anotação de converor de tipo
    public static long converteLocalDateParaLong(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // TODO: 20/04/2022 Adicionar anotação de converor de tipo
    public static LocalDate converteLongParaLocalDate(long localDate) {
        return Instant.ofEpochMilli(localDate).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
