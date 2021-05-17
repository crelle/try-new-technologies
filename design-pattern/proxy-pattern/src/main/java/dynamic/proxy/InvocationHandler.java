package dynamic.proxy;

import java.lang.reflect.Method;

/**
 * Invocation handler.
 *
 * @author Scott Smith 2018-03-01 20:05
 */
public interface InvocationHandler {

    void invoke(Method method, Object[] args);
}
