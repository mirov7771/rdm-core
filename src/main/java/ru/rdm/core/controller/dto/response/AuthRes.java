package ru.rdm.core.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.rdm.core.controller.dto.support.Client;
import ru.rdm.core.enums.Status;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AuthRes {

    private String sessionId;
    private Status status;
    @JsonProperty("access_token")
    private String accessToken;
    private String code;
    private Client client;

}
