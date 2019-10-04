package com.zjhs.hstx;


//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
@WebAppConfiguration
public class MpGenerator {

//    /**
//     * 需要修改表名 ，生成的代码请查看
//     * @param args
//     */
//        public static void main(String[] args) {
//            // 代码生成器
//            AutoGenerator mpg = new AutoGenerator();
//
//            // 全局配置
//            GlobalConfig gc = new GlobalConfig();
//            String projectPath = System.getProperty("user.dir");
//            gc.setOutputDir(projectPath + "/src/main/java");
//            gc.setAuthor("mpTool");//作者名称
//            gc.setOpen(false);
//            gc.setSwagger2(true); //实体属性 Swagger2 注解
//            gc.setFileOverride(true);
//            gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
//            gc.setEnableCache(false);// XML 二级缓存
//            gc.setBaseResultMap(true);// XML ResultMap
//            gc.setBaseColumnList(false);// XML columList
//            gc.setAuthor("mpTool");// 作者
//
//            // 自定义文件命名，注意 %s 会自动填充表实体属性！
//            gc.setControllerName("%sController");
//            gc.setServiceName("%sService");
//            gc.setServiceImplName("%sServiceImpl");
//            gc.setMapperName("%sMapper");
//            gc.setXmlName("%sMapper");
//            mpg.setGlobalConfig(gc);
//
//            // 数据源配置
//            DataSourceConfig dsc = new DataSourceConfig();
//            dsc.setUrl("jdbc:mysql://139.9.128.15:3306/hstx_db?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true");
//            // dsc.setSchemaName("public");
//            dsc.setDriverName("com.mysql.jdbc.Driver");
//            // dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql5.6以下的驱动
//            dsc.setUsername("root");
//            dsc.setPassword("admins");
//            mpg.setDataSource(dsc);
//
//            // 包配置
//            PackageConfig pc = new PackageConfig();
//            pc.setParent("com.zjhs.hstx.biz");
//            pc.setModuleName("business");
////        pc.setModuleName("dao.Impl");
//            pc.setMapper("dao");//dao
//            pc.setService("service");//servcie
//            pc.setController("controller");//controller
//            pc.setEntity("bean");
//
//            // 自定义配置
//            InjectionConfig cfg = new InjectionConfig() {
//                @Override
//                public void initMap() {
//                    // to do nothing
//                }
//            };
//
//            // 如果模板引擎是 freemarker
////            String templatePath = "/templates/mapper.xml.ftl";
//            // 如果模板引擎是 velocity
//             String templatePath = "/templates/mapper.xml.vm";
//
//            // 自定义输出配置
//            List<FileOutConfig> focList = new ArrayList<>();
//
//            //商家
//            String business = "business/";
//            //厂家
//            String manufactor = "manufactor/";
//            // 自定义配置会被优先输出
//            focList.add(new FileOutConfig(templatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//               /* return projectPath + "/src/main/resources/mappers/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;*/
//                    //根据自己的位置修改
//                    return projectPath + "/src/main/resources/mappers/"+ business +tableInfo.getEntityName() + "Mapper" + ".xml";
//                }
//            });
//        /*
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录");
//                return false;
//            }
//        });
//        */
//            mpg.setPackageInfo(pc);
//            cfg.setFileOutConfigList(focList);
//            mpg.setCfg(cfg);
//
//            // 配置模板
//            TemplateConfig templateConfig = new TemplateConfig();
//
//            // 配置自定义输出模板
//            //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//            // templateConfig.setEntity("templates/entity2.java");
//            // templateConfig.setService();
//            // templateConfig.setController();
//            //此处设置为null，就不会再java下创建xml的文件夹了
//            templateConfig.setXml(null);
//            mpg.setTemplate(templateConfig);
//
//            // 策略配置
//            StrategyConfig strategy = new StrategyConfig();
//            //表名生成策略
//            strategy.setNaming(NamingStrategy.underline_to_camel);
////            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//            //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//            strategy.setEntityLombokModel(true);
//            strategy.setRestControllerStyle(true);
//            // 公共父类
//            //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//            // 写于父类中的公共字段
//            //strategy.setSuperEntityColumns("id");
//            //表名
////            strategy.setInclude("t_admin_push_card");
//            strategy.setControllerMappingHyphenStyle(true);
//            //根据你的表名来建对应的类名，如果你的表名没有什么下划线，比如test，那么你就可以取消这一步
////            strategy.setTablePrefix("t_");
//            mpg.setStrategy(strategy);
//            mpg.setTemplateEngine(new VelocityTemplateEngine());
//            mpg.execute();
        }

//    public static void main(String[] args) {
//        AutoGenerator mpg = new AutoGenerator();
//        // 选择 freemarker 引擎，默认 Veloctiy
//        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor("mpTool");//作者名称
//        gc.setFileOverride(true);
//        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
//        gc.setEnableCache(false);// XML 二级缓存
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setBaseColumnList(false);// XML columList
//        // .setKotlin(true) 是否生成 kotlin 代码
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setServiceName("%sService");
//        // gc.setServiceImplName("%sServiceDiy");
//        // gc.setControllerName("%sAction");
//        mpg.setGlobalConfig(gc);
//
//        //数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setUrl("jdbc:mysql://139.9.128.15:3306/smtx?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        // dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql5.6以下的驱动
//        dsc.setUsername("root");
//        dsc.setPassword("admins");
//        dsc.setTypeConvert(new SqlServerTypeConvert() {
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public DbColumnType processTypeConvert(String fieldType) {
//                System.out.println("转换类型：" + fieldType);
//                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                if ((fieldType.contains("decimal") || fieldType.contains("numeric"))) {
//                    return DbColumnType.BIG_DECIMAL;
//                }
//                return super.processTypeConvert(fieldType);
//            }
//        });
//        mpg.setDataSource(dsc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
//        strategy.setTablePrefix("t_");// 此处可以修改为您的表前缀
//        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        // strategy.setInclude(new String[] { "user" }); // 需要生成的表
////        strategy.setExclude(new String[]{"snd_sys_role_permission", "snd_sys_user_role"}); // 排除生成的表
//        // 自定义实体父类
//        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
//        // 自定义实体，公共字段
//        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
//        // 自定义 mapper 父类
//        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
//        // 自定义 service 父类
//        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
//        // 自定义 service 实现类父类
//        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
//        // 自定义 controller 父类
//        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
//        // 【实体】是否生成字段常量（默认 false）
//        // public static final String ID = "test_id";
//        // strategy.setEntityColumnConstant(true);
//        // 【实体】是否为构建者模型（默认 false）
//        // public User setName(String name) {this.name = name; return this;}
//        // strategy.setEntityBuilderModel(true);
//        strategy.setRestControllerStyle(true);
//        mpg.setStrategy(strategy);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.zjhs.hstx")
//                .setModuleName("biz")
//                .setController("controller")
//                .setEntity("bean")
//                .setMapper("dao");
//        mpg.setPackageInfo(pc);
//
//        // 如果模板引擎是 freemarker
////         String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//           /* return projectPath + "/src/main/resources/mappers/" + pc.getModuleName()
//                    + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;*/
//                //根据自己的位置修改
//                return projectPath + "/src/main/resources/mappers/" +tableInfo.getEntityName() + "Mapper" + ".xml";
//            }
//        });
//
//        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
//        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
//        TemplateConfig tc = new TemplateConfig();
//        tc.setController("/templates/controller.java");
//        tc.setEntity("/templates/entity.java");
//        tc.setMapper("/templates/mapper.java");
//        tc.setXml("/templates/mapper.xml");
//        tc.setService("/templates/service.java");
//        tc.setServiceImpl("/templates/serviceImpl.java");
//        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
//        mpg.setTemplate(tc);
//
//        // 执行生成
//        mpg.execute();
//    }
//}