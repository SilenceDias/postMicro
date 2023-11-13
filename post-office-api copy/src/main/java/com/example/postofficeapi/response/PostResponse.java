package com.example.postofficeapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {
    private String postId;
    private ClientResponse sender;
    private ClientResponse receiver;
    private String postItem;
    private String status;
}
