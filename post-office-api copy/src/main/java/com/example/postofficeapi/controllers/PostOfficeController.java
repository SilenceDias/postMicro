package com.example.postofficeapi.controllers;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.feign.PostFeign;
import com.example.postofficeapi.model.PostModel;
import com.example.postofficeapi.response.ClientResponse;
import com.example.postofficeapi.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postOffice")
public class PostOfficeController {
    @Autowired
    ClientFeign clientFeign;
    @Autowired
    PostFeign postFeign;
    //post-office-api
    @GetMapping("/check")
    public String checkPostOffice(){
        return "Post-office api is working";
    }

    @GetMapping("/details/{postId}")
    public PostResponse getPostDetails(@PathVariable String postId){
        PostResponse postResponse = new PostResponse();
        PostModel postModel = postFeign.getPostById(postId);

        postResponse.setPostId(postModel.getPostId());
        postResponse.setPostItem(postModel.getPostItem());
        postResponse.setStatus(postModel.getStatus());

        postResponse.setSender(clientFeign.getClientById(postModel.getClientId()));
        postResponse.setReceiver(clientFeign.getClientById(postModel.getPostRecipientId()));

        return postResponse;
    }

    //post-core-api
    @GetMapping("/post/feign/check")
    public String checkPost(){
        return postFeign.check();
    }

    @GetMapping("/post/feign/all")
    public List<PostModel> getAllPosts(){
        return postFeign.getAllPost();
    }

    @GetMapping("/post/feign/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postFeign.getPostById(postId);
    }

    //client-core-api
    @GetMapping("/client/feign/check")
    public String checkClient(){
        return clientFeign.check();
    }

    @GetMapping("/client/feign/all")
    public List<ClientResponse> getAllClients(){
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/feign/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId){
        return clientFeign.getClientById(clientId);
    }



}
