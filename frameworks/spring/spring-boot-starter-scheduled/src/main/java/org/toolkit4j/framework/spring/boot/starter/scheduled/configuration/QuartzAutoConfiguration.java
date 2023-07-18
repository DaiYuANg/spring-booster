package org.toolkit4J.framework.spring.boot.starter.scheduled.configuration;

//@AutoConfiguration
//@ConditionalOnClass(org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration.class)
//public class QuartzAutoConfiguration {
//
//	@Resource
//	private QuartzProperties quartzProperties;
//
//	public static class AutowireCapableBeanJobFactory extends SpringBeanJobFactory {
//
//		private final AutowireCapableBeanFactory beanFactory;
//
//		@Autowired
//		public AutowireCapableBeanJobFactory(AutowireCapableBeanFactory beanFactory) {
//			Assert.notNull(beanFactory, "Bean factory must not be null");
//			this.beanFactory = beanFactory;
//		}
//
//		@Override
//		protected @NotNull Object createJobInstance(@NotNull TriggerFiredBundle bundle) throws Exception {
//			Object jobInstance = super.createJobInstance(bundle);
//			this.beanFactory.autowireBean(jobInstance);
//			this.beanFactory.initializeBean(jobInstance, "");
//			return jobInstance;
//		}
//	}
//
//	@Bean
//	public SchedulerFactoryBean schedulerFactory(@NotNull ApplicationContext applicationContext) {
//		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//		schedulerFactoryBean.setJobFactory(
//				new AutowireCapableBeanJobFactory(applicationContext.getAutowireCapableBeanFactory()));
//		return schedulerFactoryBean;
//	}
//
//	@SneakyThrows
//	@Bean
//	public Scheduler scheduler(ApplicationContext applicationContext) {
//		Scheduler scheduler = schedulerFactory(applicationContext).getScheduler();
//		scheduler.start();
//		return scheduler;
//	}
//}
