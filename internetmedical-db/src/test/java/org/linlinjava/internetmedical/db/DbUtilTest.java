package org.linlinjava.internetmedical.db;

import org.junit.Test;
import org.linlinjava.internetmedical.db.util.DbUtil;

import java.io.File;

public class DbUtilTest {
    @Test
    public void testBackup() {
        File file = new File("test.sql");
        DbUtil.backup(file, "internetmedical", "internetmedical123456", "internetmedical");
    }

//    这个测试用例会重置internetmedical数据库，所以比较危险，请开发者注意
//    @Test
    public void testLoad() {
        File file = new File("test.sql");
        DbUtil.load(file, "internetmedical", "internetmedical123456", "internetmedical");
    }
}
