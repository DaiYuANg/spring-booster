package org.toolkit.spring.boot.mapping.web.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MappingModule extends SimpleModule {
    private final MappingSerializer mappingSerializer;

    @Override
    public void setSerializers(@NotNull SimpleSerializers s) {
        s.addSerializer(mappingSerializer);
    }
}
