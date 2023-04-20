package com.klin.imageapi.service;

import com.klin.imageapi.model.Image;
import com.klin.imageapi.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    private final ImageRepository repository;
    private final GoogleVisionService visionService;

    public ImageService(ImageRepository repository, GoogleVisionService visionService){
        this.repository = repository;
        this.visionService = visionService;
    }

    public List<Image> find(List<String> objects){
        if(objects == null)
            return findAll();
        else
            return findByObjects(objects);
    }

    private List<Image> findAll(){
        return repository.findAll();
    }

    private List<Image> findByObjects(List<String> objects) {
        return repository.findAll().stream().filter(i -> i.getObjects().equals(objects)).toList();
    }

    public Image findById(long id){
        return repository.findById(id);
    }

    public Image create(String url, String label, boolean enableObjectDetection) throws IOException {
        if(label == null)
            label = visionService.detectLabelsGcs(url);

        List<String> objects = new ArrayList<>();
        if(enableObjectDetection)
            objects = visionService.detectLocalizedObjectsGcs(url);

        return repository.save(new Image(label, objects, url));
    }
}
