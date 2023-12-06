package org.toolkit.spring.boot.supervisor.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;

@Service
@Slf4j
public class OverviewServiceImpl implements OverviewService {

    public void getOverview(){
        val systemInfo = new SystemInfo();
    }
}
