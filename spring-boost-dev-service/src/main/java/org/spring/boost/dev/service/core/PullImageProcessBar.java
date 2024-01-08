/* (C)2023*/
package org.spring.boost.dev.service.core;

import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.PullResponseItem;
import lombok.extern.slf4j.Slf4j;
import me.tongfei.progressbar.DelegatingProgressBarConsumer;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class PullImageProcessBar extends PullImageResultCallback {
    private final long max = 1000;
    private final ProgressBar progressBar = new ProgressBarBuilder()
            .setTaskName("Pulling Image")
            .setStyle(ProgressBarStyle.builder().colorCode((byte) 33).build())
            .setInitialMax(max)
            .setConsumer(new DelegatingProgressBarConsumer(log::info))
            .showSpeed()
            .build();

    @Override
    public void onNext(@NotNull PullResponseItem object) {
        progressBar.stepBy(10);
        progressBar.setExtraMessage(object.getStatus());
        if (object.isPullSuccessIndicated()) {
            progressBar.stepBy(max);
            progressBar.close();
        }
    }

    @Override
    public void onError(@NotNull Throwable throwable) {
        super.onError(throwable);
        log.error("Failed to exec start:" + throwable.getMessage());
    }
}
