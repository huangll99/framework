package com.hll;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * Created by hll on 2016/7/18.
 */
public class ShiroTagFreeMarkerConigurer extends FreeMarkerConfigurer {
  @Override
  public void afterPropertiesSet() throws IOException, TemplateException {
    super.afterPropertiesSet();
    this.getConfiguration().setSharedVariable("shiro",new ShiroTags());
  }
}
