package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Publisher;
import com.mentos74.catalogue.dto.PublisherCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.PublisherRepository;
import com.mentos74.catalogue.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setAddress(dto.getAddress());
        publisher.setName(dto.getPublisherName());
        publisher.setCompanyName(dto.getCompanyName());
        publisher.setDeleted(false);

        publisherRepository.save(publisher);

    }

    @Override
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto) {
        Publisher publisher = publisherRepository.findIdBySecureId(publisherId).orElseThrow(
                () -> new BadRequestException("publisherId is not found"));

        publisher.setCompanyName(dto.getCompanyName() == null || dto.getCompanyName().isBlank() ? publisher.getCompanyName() : dto.getCompanyName());
        publisher.setName(dto.getPublisherName() == null  || dto.getPublisherName().isBlank() ? publisher.getName() : dto.getPublisherName());
        publisher.setAddress(dto.getAddress() == null || dto.getAddress().isBlank() ? publisher.getAddress() : dto.getAddress());

        publisherRepository.save(publisher);

    }
}
