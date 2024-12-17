package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.PublisherCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherListResponseDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);
    public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit, String sortBy,
                                                                             String direction, String publisherName);

}
