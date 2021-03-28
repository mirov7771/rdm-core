package ru.rdm.core.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.database.dao.UserProfile;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class JwtTokenBuilder {

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final ObjectMapper mapper = new ObjectMapper();

    public String buildToken(UserProfile profile){
        JsonObject json = new JsonObject();
        json.addProperty("userId", profile.getUserId());
        json.addProperty("email", profile.getEmail());
        json.addProperty("phone", profile.getPhone());
        json.addProperty("location", profile.getLocation());
        json.addProperty("locationId", profile.getLocationId());
        String token = encoder.encodeToString(json.toString().getBytes(StandardCharsets.UTF_8));
        token += "."+buildSession();
        return token;
    }

    public String buildSession(){
        return encoder.encodeToString(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
    }

    public Object getParamFromToken(String token, String key){
        String[] t = token.split("\\.");
        String s = new String(decoder.decode(t[0]));
        Map<String, Object> map;
        try {
            map = mapper.readValue(s, HashMap.class);
            return map.get(key);
        } catch (JsonProcessingException e){
            log.error("read token error: ", e);
            return null;
        }
    }

}
