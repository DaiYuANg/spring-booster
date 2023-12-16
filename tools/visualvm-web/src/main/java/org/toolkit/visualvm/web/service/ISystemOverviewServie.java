/* (C)2023*/
package org.toolkit.visualvm.web.service;

import org.toolkit.visualvm.web.dto.SystemOverviewDto;

public interface ISystemOverviewServie {
	SystemOverviewDto si();

	void cpuLoad();
}
