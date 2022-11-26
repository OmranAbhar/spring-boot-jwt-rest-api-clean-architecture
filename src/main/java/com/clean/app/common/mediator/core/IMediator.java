package com.clean.app.common.mediator.core;
import java.util.concurrent.CompletableFuture;

public interface IMediator {

    <TRequest extends IRequest<R>,R> R send(TRequest request) throws Exception;

    <TRequest extends IRequest<R>,R> CompletableFuture<R> sendAsync(TRequest request);
}
