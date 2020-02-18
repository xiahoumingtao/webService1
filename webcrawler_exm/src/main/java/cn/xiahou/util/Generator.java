package cn.xiahou.util;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * 启动mybaits逆向工程
 */
public class Generator {

    public static void main(String[] args) throws Exception{
        ArrayList<String> warning = new ArrayList<String>();
        File file = new File("E:\\ProJectLocalDepository\\webService\\webcrawler_exm\\src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser parser = new ConfigurationParser(warning);
        Configuration configuration = parser.parseConfiguration(file);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warning);
        myBatisGenerator.generate(null);
    }
}
