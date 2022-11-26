package com.clean.app.common.mediator.spring;

import com.clean.app.common.mediator.core.IMediator;
import com.clean.app.common.mediator.core.IRequest;
import com.clean.app.common.mediator.core.MediatorThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class SpringMediator implements IMediator {
    private ApplicationContext context;
    private SpringRegistry registry;
    private String basePackage;

    private Executor executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new MediatorThreadFactory());
    private Logger logger = LoggerFactory.getLogger(SpringMediator.class);

    public SpringMediator(ApplicationContext context, String basePackage) {
        this.context = context;
        this.basePackage = basePackage;
        this.registry = new SpringRegistry(this.context, this.basePackage);
    }

    @Override
    public <TRequest extends IRequest<R>, R> R send(TRequest request) {
        try {
            return (R) registry.getRequestHandler(request.getClass()).handle(request);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public <TRequest extends IRequest<R>, R> CompletableFuture<R> sendAsync(TRequest request) {
        try {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    return (R) registry.getRequestHandler(request.getClass()).handle(request);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }, executors::execute);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
