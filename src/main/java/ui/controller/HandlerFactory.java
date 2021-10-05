package ui.controller;

import domain.service.AppService;

public class HandlerFactory {

    public RequestHandler getHandler(String command, AppService service) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui.controller." + command);
            Object objectHandler = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) objectHandler;
            handler.setService(service);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!");
        }
        return handler;
    }
}
