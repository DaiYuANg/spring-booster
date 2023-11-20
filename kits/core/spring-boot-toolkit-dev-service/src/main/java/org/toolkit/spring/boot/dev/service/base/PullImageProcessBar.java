package org.toolkit.spring.boot.dev.service.base;

import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.PullResponseItem;
import lombok.extern.slf4j.Slf4j;
import me.tongfei.progressbar.DelegatingProgressBarConsumer;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class PullImageProcessBar extends PullImageResultCallback implements AutoCloseable {
    private final ProgressBar progressBar = new ProgressBarBuilder()
            .setTaskName("Pulling Image")
            .setStyle(ProgressBarStyle.builder()
                    .colorCode((byte) 33)
                    .build())
            .setInitialMax(10000)
            .setConsumer(new DelegatingProgressBarConsumer(log::info))
            .showSpeed()
            .build();

    @Override
    public void onNext(@NotNull PullResponseItem object) {
        super.onNext(object);
        progressBar.stepBy(10);
    }

    @Override
    public void onComplete() {
//        progressBar.stepBy(progressBar.getMax());
//        progressBar.close();
    }

    @Override
    public void onError(@NotNull Throwable throwable) {
        log.error("Failed to exec start:" + throwable.getMessage());
        super.onError(throwable);
    }

    @Override
    public void close() {
        progressBar.close();
    }
}
