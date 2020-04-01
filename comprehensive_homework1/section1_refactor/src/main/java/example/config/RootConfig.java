package example.config;

import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Import({DataConfig.class, CacheConfig.class})
@ComponentScan(basePackages = {"example"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
        })
public class RootConfig {

//    @Profile("qa")
//    @ComponentScan(basePackages = "example.dao")
//    public static class testClass{
//        public testClass() {
//
//        }
//    }

    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("example\\.web"));
        }
    }



}
