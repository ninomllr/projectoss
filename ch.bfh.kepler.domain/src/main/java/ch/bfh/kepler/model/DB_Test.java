package ch.bfh.kepler.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateIT.class, ReadIT.class, UpdateIT.class, DeleteIT.class })
public class DB_Test {

}
