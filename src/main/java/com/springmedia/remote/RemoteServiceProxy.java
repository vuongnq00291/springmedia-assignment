package com.springmedia.remote;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springmedia.config.APIConfig;
import com.springmedia.config.RemoteServicesConfig;

@Service
@Scope(value="singleton")
public class RemoteServiceProxy implements InvocationHandler{
	
  @Autowired
  private RemoteServicesConfig config;	
  
  private final RestTemplate restTemplate = new RestTemplate();
  
  public Object invoke(Object object, Method method, Object[] args) throws Throwable {  
	  if(method.getName().equals("hashCode")){
		  return generateRandomInt();
	  }
	  RemoteService rma = method.getDeclaringClass().getAnnotation(RemoteService.class);
	  String key = rma.name()+"-"+method.getName().toLowerCase();
	  APIConfig methodConfig = config.getApis().get(key);
	  
	  
	  String url = MessageFormat.format(methodConfig.getUrl(), args) ;
	  Object results = restTemplate.getForObject(url, method.getReturnType());
	  return results;
  }
  

  public static int generateRandomInt(){
    Random random = new Random();
    return random.nextInt(Integer.MAX_VALUE);
  }
  
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  public  <T> T NewBuilderProxy(Class<T> mapperInterface) {
    ClassLoader classLoader = mapperInterface.getClassLoader();
    Class[] interfaces = new Class[]{mapperInterface};
    return (T) Proxy.newProxyInstance(classLoader, interfaces, this);
  }


public RemoteServicesConfig getConfig() {
	return config;
}


public void setConfig(RemoteServicesConfig config) {
	this.config = config;
}
  
}
