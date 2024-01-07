/* (C)2024*/
package org.spring.boost.office.process;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import lombok.val;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.spring.boost.office.annotation.ExcelRow;
import org.spring.boost.office.excel.Workbook;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ExportProcessorTest {

    @Data
    @Accessors(chain = true)
    class test {

        @ExcelRow(title = "测试")
        private String a;
    }

    @SneakyThrows
    @Test
    void generateExcel() {
        val f = new Faker();
        val testData = IntStream.range(0, 100)
                .mapToObj(r -> new test().setA(f.name().fullName()))
                .collect(Collectors.toUnmodifiableSet());
        val w= Workbook.<test>builder()
                .title("test")
                .entityClass(test.class)
                .entityData(testData)
                .build();
        ;
//        val inputStream = new ByteArrayInputStream(w.generateExcel());
//        Path outputPath = Path.of("outputFile.xlsx");
//        Files.copy(inputStream, outputPath, StandardCopyOption.REPLACE_EXISTING);
//        System.out.println("File written successfully.");
    }
}
