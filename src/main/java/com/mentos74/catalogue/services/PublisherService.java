package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.PublisherCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

}
