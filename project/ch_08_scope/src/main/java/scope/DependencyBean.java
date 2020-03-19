package scope;

public class DependencyBean {

	private InjectionBean injectionBean;
	
	public DependencyBean(InjectionBean injectionBean) {
		System.out.println("Dependency Constructor");
		this.injectionBean = injectionBean;
	}

	public InjectionBean getInjectionBean() {
		return injectionBean;
	}

	public void setInjectionBean(InjectionBean injectionBean) {
		System.out.println("injection Setter");
		this.injectionBean = injectionBean;
	}
}
