package com.qy.base.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Lautumn
 * @Describe: 资源工具类
 * @Date: Create in 15:15 2019/10/11
 */
public class ClassPathResourceReader {

    public static InputStream getFilePath(String resourcePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(resourcePath);
        return resource.getInputStream();

    }
}
