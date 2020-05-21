

import org.jeecgframework.codegenerate.database.DbReadTableUtil;
import org.jeecgframework.codegenerate.generate.impl.CodeGenerateOne;
import org.jeecgframework.codegenerate.generate.pojo.TableVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.StringUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;


/**
 * 每次修改数据库中任何一张表都执行一下
 */
public class CommGenerateEntity {


    private static final Logger a = LoggerFactory.getLogger(DbReadTableUtil.class);
    private static Connection b;
    private static Statement c;

    /**
     * 数据库版
     *
     * 详细使用手册： http://jeecg-boot.mydoc.io/?t=338140
     *
     * select  table_name tableName,table_comment commentName from information_schema.tables where table_schema='newstorev2'
     */
//    public static void main(String[] args) throws Exception {
//        //------------------不要忘记生成后提交实体类代码--------------
//        //生成输入表的实体类
//        oneTable("authentication","设计师/施工人员认证信息 工作室认证");
//       // allTbales();
//
//    }

    /**
     *
     * @param tableName 表名字
     * @param tableComment 表描述
     * @throws Exception
     */
    public static void oneTable(String tableName,String tableComment) throws Exception{
        ArrayList var2 = new ArrayList(0);
        TableVo var3x = new TableVo();
        if (StringUtil.isNotEmpty(tableName)) {
            var3x.setTableName(tableName.trim());//表名
            var3x.setEntityPackage("entity");//文件夹名字
                var3x.setEntityName(StringUtil.convertTableName2EntityName(tableName.trim()));//实体类名字
                var3x.setSequenceCode("id");//主键
                if (StringUtil.isNotEmpty(tableComment)) {
                var3x.setFtlDescription(tableComment.trim());//描述
            } else if (StringUtil.isEmpty(tableComment)) {
                var3x.setFtlDescription("");//描述
            } else {
                throw new Exception();
            }
        }
        CodeGenerateOne codeGenerateOne = new CodeGenerateOne(var3x);
        codeGenerateOne.generateCodeFile("");
        Thread.sleep(10);
    }



    public static void allTbales()throws Exception{
        ArrayList var2 = new ArrayList(0);
        b = DriverManager.getConnection(org.jeecgframework.codegenerate.a.a.c, org.jeecgframework.codegenerate.a.a.d, org.jeecgframework.codegenerate.a.a.e);
        c = b.createStatement(1005, 1007);
        String var1 = MessageFormat.format("select  table_name tableName,table_comment commentName from information_schema.tables where table_schema={0}", org.jeecgframework.codegenerate.generate.util.c.c(org.jeecgframework.codegenerate.a.a.f));
        ResultSet var0 = c.executeQuery(var1);
        while(var0.next()) {
            String tableName = var0.getString(1);
            String tableComment = var0.getString(2);
            TableVo var3x = new TableVo();
            if (StringUtil.isNotEmpty(tableName)) {
                var3x.setTableName(tableName.trim());//表名
                var3x.setEntityPackage("entity");//文件夹名字
                var3x.setEntityName(StringUtil.convertTableName2EntityName(tableName.trim()));//实体类名字
                var3x.setSequenceCode("id");//主键
                if (StringUtil.isNotEmpty(tableComment)) {
                    var3x.setFtlDescription(tableComment.trim());//描述
                } else if (StringUtil.isEmpty(tableComment)) {
                    var3x.setFtlDescription("");//描述
                } else {
                    throw new Exception();
                }
            }
            CodeGenerateOne codeGenerateOne = new CodeGenerateOne(var3x);
            codeGenerateOne.generateCodeFile("");
            Thread.sleep(10);
        }
    }



}