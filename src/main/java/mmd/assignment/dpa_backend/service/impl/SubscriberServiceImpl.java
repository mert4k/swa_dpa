package mmd.assignment.dpa_backend.service.impl;

import lombok.AllArgsConstructor;
import mmd.assignment.dpa_backend.dto.SubscriberDto;
import mmd.assignment.dpa_backend.entity.Subscriber;
import mmd.assignment.dpa_backend.exception.SubscriberNotFoundException;
import mmd.assignment.dpa_backend.mapper.SubscriberMapper;
import mmd.assignment.dpa_backend.repository.SubscriberRepository;
import mmd.assignment.dpa_backend.service.SubscriberService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberRepository subscriberRepository;

    @Override
    public SubscriberDto createSubscriber(SubscriberDto subscriberDto) {
        Assert.notNull(subscriberDto.getName(), "Subscriber name can not be empty.");
        Subscriber subscriber = SubscriberMapper.mapToSubscriber(subscriberDto);
        Subscriber savedSubscriber = subscriberRepository.save(subscriber);
        return SubscriberMapper.mapToSubscriberDto(savedSubscriber);
    }

    @Override
    public SubscriberDto getSubscriberById(long subscriberId) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(
                        () -> new SubscriberNotFoundException("Subscriber is not exist with given id: " + subscriberId)
                );
        return SubscriberMapper.mapToSubscriberDto(subscriber);
    }

    @Cacheable("subscribers")
    @Override
    public List<SubscriberDto> getAllSubscribers() {
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        return subscriberList.stream()
                .map((subscriber) -> SubscriberMapper.mapToSubscriberDto(subscriber))
                .collect(Collectors.toList());
    }

    @Override
    public SubscriberDto updateSubscriber(Long subscriberId, SubscriberDto updatedSubscriber) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(
                        () -> new SubscriberNotFoundException("Subscriber not found.")
                );
        subscriber.setName(updatedSubscriber.getName());
        subscriber.setMsisdn(updatedSubscriber.getMsisdn());

        Subscriber updatedSubscriberObj = subscriberRepository.save(subscriber);

        return SubscriberMapper.mapToSubscriberDto(updatedSubscriberObj);
    }

    @CacheEvict(value = "subscribers", key = "#id")
    @Override
    public void deleteSubscriber(Long subscriberId) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(
                        () -> new SubscriberNotFoundException("Subscriber not found.")
                );

        subscriberRepository.delete(subscriber);
    }
}
