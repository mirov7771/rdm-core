package ru.rdm.core.security.jwt;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;
import ru.rdm.core.database.dao.UserProfile;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Component
public class JwtTokenBuilder {

    private static final Base64.Encoder encoder = Base64.getEncoder();

    public String buildToken(UserProfile profile){
        JsonObject json = new JsonObject();
        json.addProperty("userId", profile.getUserId());
        json.addProperty("email", profile.getEmail());
        json.addProperty("phone", profile.getPhone());
        json.addProperty("location", profile.getLocation());
        String token = encoder.encodeToString(json.toString().getBytes(StandardCharsets.UTF_8));
        token += "."+buildSession();
        return token;
    }

    public String buildSession(){
        return encoder.encodeToString(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
    }

}
