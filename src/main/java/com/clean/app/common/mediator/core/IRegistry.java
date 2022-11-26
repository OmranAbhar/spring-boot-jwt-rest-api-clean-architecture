package com.clean.app.common.mediator.core;

public interface IRegistry {
    <T extends IRequest<R>,R > IRequestHandler<T,R> getRequestHandler(Class<T> requestType);
}
