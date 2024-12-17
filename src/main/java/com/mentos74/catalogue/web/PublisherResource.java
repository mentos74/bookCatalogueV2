package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.PublisherCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;
import com.mentos74.catalogue.services.impl.PublisherServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class PublisherResource {

    private PublisherServiceImpl psm;

    @PostMapping("/v1/publisher")
    public ResponseEntity<Void> createNewPublisher(@RequestBody @Valid PublisherCreateRequestDTO dto){
        psm.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher")).build();
    }

    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updatePublisher(@RequestBody PublisherUpdateRequestDTO dto, @PathVariable String publisherId){
        psm.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
    }

}
