package unit;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;

/**
 * Base class for all unit tests
 */
public abstract class UnitTestCase {
    /**
     * Set up a context for performing mocks using JMock
     */
    protected final Mockery context = new JUnit4Mockery(){{
        setThreadingPolicy(new Synchroniser());
    }};

}
