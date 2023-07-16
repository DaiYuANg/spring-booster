package org.toolkit4J.framework.spring.boot.starter.scheduled.configuration;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.quartz.Scheduler;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.util.Assert;

@AutoConfiguration
@ConditionalOnClass(org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration.class)
public class QuartzAutoConfiguration {

	@Resource
	private QuartzProperties quartzProperties;

	public static class AutowireCapableBeanJobFactory extends SpringBeanJobFactory {

		private final AutowireCapableBeanFactory beanFactory;

		@Autowired
		public AutowireCapableBeanJobFactory(AutowireCapableBeanFactory beanFactory) {
			Assert.notNull(beanFactory, "Bean factory must not be null");
			this.beanFactory = beanFactory;
		}

		@Override
		protected @NotNull Object createJobInstance(@NotNull TriggerFiredBundle bundle) throws Exception {
			Object jobInstance = super.createJobInstance(bundle);
			this.beanFactory.autowireBean(jobInstance);
			this.beanFactory.initializeBean(jobInstance, "");
			return jobInstance;
		}
	}

	@Bean
	public SchedulerFactoryBean schedulerFactory(@NotNull ApplicationContext applicationContext) {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setJobFactory(
				new AutowireCapableBeanJobFactory(applicationContext.getAutowireCapableBeanFactory()));
		return schedulerFactoryBean;
	}

	@SneakyThrows
	@Bean
	public Scheduler scheduler(ApplicationContext applicationContext) {
		Scheduler scheduler = schedulerFactory(applicationContext).getScheduler();
		scheduler.start();
		return scheduler;
	}
}
