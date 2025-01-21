package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.PublisherCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherListResponseDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;
import com.mentos74.catalogue.services.impl.PublisherServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class PublisherResource {

    private final PublisherServiceImpl psm;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/publisher")
    public ResponseEntity<Void> createNewPublisher(@RequestBody @Valid PublisherCreateRequestDTO dto) {
        psm.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher")).build();
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updatePublisher(@RequestBody PublisherUpdateRequestDTO dto, @PathVariable String publisherId) {
        psm.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/v1/publisher")
    public ResponseEntity<ResultPageResponseDTO<PublisherListResponseDTO>> findPublisherList(
            @RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "publisherName", required = false) String publisherName) {

        return ResponseEntity.ok().body(psm.findPublisherList(pages, limit, sortBy, direction, publisherName));
    }

}
