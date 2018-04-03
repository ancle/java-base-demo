package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import proxy.intf.Person;

public class HomeLink implements InvocationHandler {
	private Person target;
	
	public HomeLink(Person target) {
		this.target = target;
	}
	
	public Object getInstance() {
		Class clazz = target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是链家，我帮别人找房子...");
		
		Object result = method.invoke(target, args);
		
		System.out.println("我是链家，已经找完房子了...");
		
		return result;
	}

}
