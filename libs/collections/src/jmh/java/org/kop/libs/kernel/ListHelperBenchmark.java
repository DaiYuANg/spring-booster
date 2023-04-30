package org.kop.libs.kernel;

import lombok.SneakyThrows;
import org.kop.libs.collections.lists.OptionalList;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.stream.IntStream;

public class ListHelperBenchmark {
    @Benchmark
    public void testGet(Blackhole blackhole) {
        var r = new OptionalList<>();
        r.addAll(IntStream.range(0, 99999).asLongStream().boxed().toList());
        blackhole.consume(r.optionalGet(50));
    }

    @SneakyThrows
    public static void main(String[] args) {
        Options opt = new OptionsBuilder()
                .include(ListHelperBenchmark.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }
}
