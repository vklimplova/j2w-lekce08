package cz.czechitas.java2webapps.lekce8.freemarker;

import cz.czechitas.java2webapps.lekce8.freemarker.Java8TimeObjectWrapper;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.DefaultObjectWrapperConfiguration;
import freemarker.template.Version;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Configuration
public class FreemarkerConfig implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof FreeMarkerConfigurer configurer) {
      Java8TimeObjectWrapperConfiguration objectWrapperConfiguration = new Java8TimeObjectWrapperConfiguration(freemarker.template.Configuration.VERSION_2_3_31);
      Java8TimeObjectWrapper objectWrapper = new Java8TimeObjectWrapper(objectWrapperConfiguration, true);
      configurer.getConfiguration().setObjectWrapper(objectWrapper);
    }
    return bean;
  }

  private static class Java8TimeObjectWrapperConfiguration extends DefaultObjectWrapperConfiguration {
    protected Java8TimeObjectWrapperConfiguration(Version incompatibleImprovements) {
      super(incompatibleImprovements);
      setIterableSupport(true);
    }
  }
}
