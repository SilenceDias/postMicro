package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.PostModel;
import com.example.postofficeapi.response.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("post-core-api")
public interface PostFeign {
    @GetMapping("/post/check")
    String check();

    @GetMapping("/post/all")
    List<PostModel> getAllPost();

    @GetMapping("/post/{postId}")
    PostModel getPostById(@PathVariable String postId);


}
