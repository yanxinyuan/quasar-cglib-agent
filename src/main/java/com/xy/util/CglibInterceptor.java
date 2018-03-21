package com.xy.util;

import java.lang.reflect.Method;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author Xinyuan.Yan
 *
 */
public class CglibInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws SuspendExecution, Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Fiber.park();
		}
		return null;
	}

}
