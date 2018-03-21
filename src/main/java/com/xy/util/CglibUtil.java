package com.xy.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 
 * @author Xinyuan.Yan
 *
 */
public class CglibUtil {
	
	public static Object generate(Class<?> iClass) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(iClass);
		enhancer.setCallbackFilter(new CallbackFilter () {
			@Override
			public int accept(Method method) {
				List<Method> methods = Arrays.asList(iClass.getDeclaredMethods());
				int num = methods.contains(method) ? 0 : 1;
				return num;
			}
		});
		enhancer.setCallbacks(new Callback[] { new CglibInterceptor(), NoOp.INSTANCE });
		Object obj = enhancer.create();
		return obj;
	}
	
}
