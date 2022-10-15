package com.lxk.mgr.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.lxk.mgr.controller.base.BaseController;
import com.lxk.mgr.entity.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collections;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-20 15:17
 */
@Slf4j
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
                    builder.parent("com.lxk.mgr") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://gen/mapper")); // 设置mapperXml生成路径
                })
                .templateConfig(builder -> {
                    builder.controller("/templates/controller.java");
                    builder.mapper("/templates/mapper.xml.vm");
                    builder.serviceImpl("/templates/serviceImpl.java.vm");
                })
                .strategyConfig(builder -> {
                    // controller
                    builder.controllerBuilder().superClass(BaseController.class).enableRestStyle().enableFileOverride();
                    // entity
                    builder.entityBuilder().superClass(BaseEntity.class).enableLombok().disableSerialVersionUID()
                            .addSuperEntityColumns("id","created_by","created_by_name","created_date","modified_by",
                                    "modified_by_name", "modified_date", "status").enableFileOverride();
                    // mapper
                    builder.mapperBuilder().superClass(BaseMapper.class).mapperAnnotation(Repository.class)
                            .enableBaseColumnList().enableBaseResultMap().enableFileOverride();

                    // service
                    builder.serviceBuilder().convertServiceFileName(entityName -> entityName + ConstVal.SERVICE).enableFileOverride();

                    builder.addInclude("t_.*");
                    builder.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                //.templateConfig(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
