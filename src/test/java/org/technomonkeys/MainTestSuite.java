package org.technomonkeys;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.technomonkeys.dao.DaoTest;
import org.technomonkeys.misc.LoggerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( { DaoTest.class, LoggerTest.class })
public class MainTestSuite {
}
