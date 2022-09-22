package com.lxk.mgr.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;

import java.util.Collections;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-20 15:17
 */
public class CodeGenerate {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://172.20.243.7:3306/sdm", "sunbox", "SUNBOX@TBD7")
                .globalConfig(builder -> {
                    builder.author("liuxiaokun") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .commentDate("yyyy-MM-dd HH:mm:ss")
                            .outputDir("D://gen"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lxk") // 设置父包名
                            .moduleName("mgr") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://gen")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.likeTable(new LikeTable("t_*")); // 设置需要生成的表名
                            builder.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                //.templateConfig(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
