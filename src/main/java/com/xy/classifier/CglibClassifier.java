package com.xy.classifier;

import co.paralleluniverse.fibers.instrument.MethodDatabase;

/**
 * 
 * @author Xinyuan.Yan
 *
 */
public class CglibClassifier implements co.paralleluniverse.fibers.instrument.SuspendableClassifier {
	
	@Override
	public MethodDatabase.SuspendableType isSuspendable(MethodDatabase db, String sourceName, String sourceDebugInfo, boolean isInterface, String className, String superClassName, String[] interfaces, String methodName, String methodDesc, String methodSignature, String[] methodExceptions) {
		if (className.equals("net/sf/cglib/proxy/MethodInterceptor") && methodName.equals("intercept")) {
			return MethodDatabase.SuspendableType.SUSPENDABLE;
		}
		return null;
	}
}