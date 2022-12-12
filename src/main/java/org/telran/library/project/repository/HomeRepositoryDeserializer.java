package org.telran.library.project.repository;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class HomeRepositoryDeserializer implements JsonDeserializer <HomeRepository> {

    private String homeRepositoryTypeElementName;
    private Gson gson;
    private Map<String, Class<? extends HomeRepository>> homeRepositoryTypeRegistry;


    public HomeRepositoryDeserializer(String homeRepositoryTypeElementName) {
        this.homeRepositoryTypeElementName = homeRepositoryTypeElementName;
        this.gson = new Gson();
        this.homeRepositoryTypeRegistry = new HashMap<>();
    }

    public void registerBarnType(String homeRepositoryTypeName, Class<? extends HomeRepository> homeRepositoryType) {
        homeRepositoryTypeRegistry.put(homeRepositoryTypeName, homeRepositoryType);
    }

    public HomeRepository deserialize (JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject homeRepositoryObject = json.getAsJsonObject();
        JsonElement homeRepositoryTypeElement = homeRepositoryObject.get(homeRepositoryTypeElementName);

        Class<? extends HomeRepository> homeRepositoryType = homeRepositoryTypeRegistry.get(homeRepositoryTypeElement.getAsString());
        return gson.fromJson(homeRepositoryObject, homeRepositoryType);
    }
}
