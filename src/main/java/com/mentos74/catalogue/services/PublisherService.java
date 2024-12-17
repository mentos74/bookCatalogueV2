package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.PubliserCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;

public interface PublisherService {

    public void createPublisher(PubliserCreateRequestDTO dto);
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

}
