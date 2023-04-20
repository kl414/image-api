package com.klin.imageapi.controller;

import com.klin.imageapi.model.Image;
import com.klin.imageapi.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/images")
public class ImageController {
    private final ImageService service;

    public ImageController(ImageService service){
        this.service = service;
    }

    @GetMapping()
    public List<Image> find(@RequestParam(required = false) List<String> objects){
        return service.find(objects);
    }

    @GetMapping("/{id}")
    public Image findById(@PathVariable long id){
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public Image create(@RequestParam String url, @RequestParam(required = false) String label, @RequestParam(required = false) boolean enableObjectDetection) throws IOException {
        return service.create(url, label, enableObjectDetection);
    }
}
