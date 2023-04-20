package com.klin.imageapi.repository;

import com.klin.imageapi.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {
    List<Image> findAll();
    Image findById(long id);
}
