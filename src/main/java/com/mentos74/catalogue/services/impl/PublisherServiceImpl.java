package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Publisher;
import com.mentos74.catalogue.dto.PublisherCreateRequestDTO;
import com.mentos74.catalogue.dto.PublisherListResponseDTO;
import com.mentos74.catalogue.dto.PublisherUpdateRequestDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.PublisherRepository;
import com.mentos74.catalogue.services.PublisherService;
import com.mentos74.catalogue.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        publisher.setName(dto.getPublisherName() == null || dto.getPublisherName().isBlank() ? publisher.getName() : dto.getPublisherName());
        publisher.setAddress(dto.getAddress() == null || dto.getAddress().isBlank() ? publisher.getAddress() : dto.getAddress());

        publisherRepository.save(publisher);

    }

    @Override
    public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit, String sortBy, String direction, String publisherName) {
        publisherName = StringUtils.isBlank(publisherName) ? "%" : publisherName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction),sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Publisher> pageResult = publisherRepository.findByNameLikeIgnoreCase(publisherName, pageable);

        List<PublisherListResponseDTO> dtos = pageResult.stream().map((x) -> {
            PublisherListResponseDTO publisherListResponseDTO = new PublisherListResponseDTO();
            publisherListResponseDTO.setPublisherName(x.getName());
            publisherListResponseDTO.setCompanyName(x.getCompanyName());
            publisherListResponseDTO.setPublisherId(x.getSecureId());
            return publisherListResponseDTO;
        }).collect(Collectors.toList());

        return PaginationUtil.createResultDTO(dtos, pageResult.getTotalElements(),pageResult.getTotalPages());
    }

    @Override
    public Publisher findPublisher(String idPublisher) {
        Publisher publisher = publisherRepository.findIdBySecureId(idPublisher).orElseThrow(()->new BadRequestException("publisher id not found"));
        return publisher;
    }
}
