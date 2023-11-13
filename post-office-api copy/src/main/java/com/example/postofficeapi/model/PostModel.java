package com.example.postofficeapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
    private String postId;
    private String clientId;
    private String postRecipientId;
    private String postItem;
    private String status;
}
