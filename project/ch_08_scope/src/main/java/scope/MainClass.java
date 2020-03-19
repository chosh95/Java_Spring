package scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		InjectionBean injectionBean = ctx.getBean("injectionBean",InjectionBean.class);
		DependencyBean dep1 = ctx.getBean("dependencyBean", DependencyBean.class);
		DependencyBean dep2 = ctx.getBean("dependencyBean", DependencyBean.class);
		
		if(dep1.equals(dep2)) {
			System.out.println("dep1 == dep2");
		}
		else {
			System.out.println("dep1 != dep2");
		}
		
		ctx.close();
	}

}
