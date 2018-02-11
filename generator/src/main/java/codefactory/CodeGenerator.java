package codefactory;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class CodeGenerator {

    public static void main(String[] args) throws Exception {
        //模板路径
		String templatePath = "D:\\project\\codeFactory\\src\\main\\resources\\template";
//        String templatePath = "D:\\apache-maven-3.5.2\\repository\\com\\googlecode\\rapid-framework\\rapid-generator-template\\4.0.6\\generator\\template";

        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(templatePath);

        // 删除生成器的输出目录//
        g.deleteOutRootDir();

        // 通过数据库表生成文件
//		g.generateByTable("parking_report_today");
//		g.generateByTable("parking_report_daily");
//		g.generateByTable("parking_report_monthly");
//		g.generateByTable("parking_account_balance");
//		g.generateByTable("parking_account_contract");
//		g.generateByTable("parking_account_settlement");
//		g.generateByTable("parking_account_transaction");
//		g.generateByTable("parking_account_withdraw");
//		g.generateByTable("parking_stop_record_abnormal");
//		g.generateByTable("parking_inpark_record");
//		g.generateByTable("parking_outpark_record");
//		g.generateByTable("parking_parkrealtime_record");
//		g.generateByTable("parking_stop_record");
//		g.generateByTable("parking_online_settlement_record");
//		g.generateByTable("parking_basic_info");
        g.generateByTable("customer_basic_info");
//		g.generateByTable("user_collect_parking");

        // 自动搜索数据库中的所有表并生成文件,template为模板的根目录
        // g.generateByAllTable();

        // 按table名字删除文件
        // g.deleteByTable("table_name", "template");

    }

}
