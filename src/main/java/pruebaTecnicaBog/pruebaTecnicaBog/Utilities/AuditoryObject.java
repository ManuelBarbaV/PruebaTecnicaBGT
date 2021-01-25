package pruebaTecnicaBog.pruebaTecnicaBog.Utilities;

import com.google.gson.Gson;

public class AuditoryObject {

    //Variables empleadas para las auditorias
    Object gsonRequest = new Object();
    Object gsonResponse = new Object();
    String action = "";

    public Object getGsonRequest() {
        Gson gson = new Gson();
        return gson.toJson(this.gsonRequest);
    }

    public void setGsonRequest(Object gsonRequest) {
        this.gsonRequest = gsonRequest;
    }

    public Object getGsonResponse() {
        Gson gson = new Gson();
        return gson.toJson(this.gsonResponse);
    }

    public void setGsonResponse(Object gsonResponse) {
        this.gsonResponse = gsonResponse;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
