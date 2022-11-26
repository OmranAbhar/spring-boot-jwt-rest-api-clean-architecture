package com.clean.app.common.mediator.spring;

import com.clean.app.common.mediator.core.IRegistry;
import com.clean.app.common.mediator.core.IRequest;
import com.clean.app.common.mediator.core.IRequestHandler;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class SpringRegistry implements IRegistry {
    private ApplicationContext context;
    private String basePackage;
    private Map<Class<IRequest<?>>, Class<? extends IRequestHandler>> requestRegistry = new HashMap<>();
    private static final String REQUEST_FULL_NAME = "com.clean.app.common.mediator.core.IRequest";
    public SpringRegistry(ApplicationContext context, String basePackage){
        this.context = context;
        this.basePackage = basePackage;
        this.initialize();
    }

    private void initialize(){
        Reflections reflections = new Reflections(this.basePackage);
        reflections.getSubTypesOf(IRequestHandler.class).forEach(cur -> {
            Class<IRequest<?>> requestClass = this.geRequestClass(cur);
            requestRegistry.put(requestClass,cur);
        });
    }

    private Class<IRequest<?>> geRequestClass(Class<? extends IRequestHandler> cur) {
        Class[] types = GenericTypeResolver.resolveTypeArguments(cur,IRequestHandler.class);
        AtomicReference<Class<IRequest<?>>> requestClass = new AtomicReference<>();
        if (types != null) {
            Arrays.stream(types).forEach(type -> {
                Arrays.stream(type.getInterfaces()).forEach(iface -> {
                    if(iface.getTypeName().equals(REQUEST_FULL_NAME)){
                        requestClass.set(type);
                    }
                });
            });
        }
        return requestClass.get();
    }

    @Override
    public <T extends IRequest<R>, R> IRequestHandler<T, R> getRequestHandler(Class<T> requestType) {
        Class<? extends IRequestHandler> aClass = requestRegistry.get(requestType);
        return context.getAutowireCapableBeanFactory().createBean(aClass);
    }
}
