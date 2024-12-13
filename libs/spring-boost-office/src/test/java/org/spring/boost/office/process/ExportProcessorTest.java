/* (C)2024*/
package org.spring.boost.office.process;

import com.github.noconnor.junitperf.JUnitPerfInterceptor;
import com.github.noconnor.junitperf.JUnitPerfTest;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import lombok.val;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.spring.boost.office.annotation.ExcelRow;
import org.spring.boost.office.excel.Workbook;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(JUnitPerfInterceptor.class)
@SpringBootTest
@RunWith(SpringRunner.class)
// @Suite
// @ConfigurationParameter(key = "junit.jupiter.extensions.autodetection.enabled", value = "true")
@JUnitPerfTest(threads = 50, durationMs = 1200, warmUpMs = 100, maxExecutionsPerSecond = 110)
class ExportProcessorTest {

    private MemoryMXBean memoryMXBean;
    private MemoryUsage startMemoryUsage;

    @Data
    @Accessors(chain = true)
    static class test {

        @ExcelRow(title = "测试")
        private String name;

        @ExcelRow(title = "地址")
        private String address;

        @ExcelRow(title = "头像")
        private String avatar;
    }

    @BeforeEach
    void setUp() {
        memoryMXBean = ManagementFactory.getMemoryMXBean();
        startMemoryUsage = memoryMXBean.getHeapMemoryUsage();
    }

    @SneakyThrows
    @Test
    void generateExcel() {
        val f = new Faker();
        val testData = IntStream.range(0, 99999999)
                .mapToObj(r -> new test()
                        .setName(f.name().fullName())
                        .setAddress(f.address().fullAddress())
                        .setAvatar(f.avatar().image()))
                .collect(Collectors.toUnmodifiableSet());

        val w = Workbook.<test>builder()
                .title("test")
                .entityClass(test.class)
                .entityData(testData)
                .build();
        w.generateExcel();
    }

    @AfterEach
    void tearDown() {
        MemoryUsage endMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        long usedMemory = endMemoryUsage.getUsed() - startMemoryUsage.getUsed();

        System.out.println("Used Memory: " + formatMemory(usedMemory));
    }

    private String formatMemory(long bytes) {
        return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
    }
}
