package com.mentos74.catalogue.services;

import com.mentos74.catalogue.domain.Publisher;
import com.mentos74.catalogue.dto.*;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);
    public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit, String sortBy,
                                                                             String direction, String publisherName);
    public Publisher findPublisher(String idPublisher);
    public PublisherResponseDTO constructDTO(Publisher publisher);
}
