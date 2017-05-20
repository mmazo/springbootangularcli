package de.mmazo.learn.backend.api.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by mmazo on 14.05.17.
 */
@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImage(file.getBytes());
        return this.imageRepository.save(image);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable(value="id") long id) {
        byte[] image = this.imageRepository.findOne(id).getImage();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable(value="id") long id) {
        this.imageRepository.delete(id);
    }

}
