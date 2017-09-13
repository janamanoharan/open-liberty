package com.ibm.ws.ras;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

public class ByteArrayClassLoader extends URLClassLoader {
	
	private Map<String, byte[]> classDefs;
	String packageName = "com.ibm.example.bytecode";
	
	public ByteArrayClassLoader(ClassLoader parent, Map<String, byte[]> defs) {
		super(new URL[0], parent);
		
		this.classDefs = defs;
		
	}
	
	public void setPackage(String packageName) {
		this.packageName = packageName;
	}
	
	@Override
	protected Class findClass(String name) throws ClassNotFoundException {
		
		if (!this.classDefs.containsKey(name))
			return super.findClass(name);

		if (getPackage(packageName) == null)
			definePackage(packageName, null, null, null, null, null, null, null);
		Class definedClass = defineClass(name, this.classDefs.get(name), 0, this.classDefs.get(name).length); 
		if (definedClass != null)
			return definedClass;
		else
			return super.findClass(name);
	}
	
	

}
