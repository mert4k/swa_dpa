package mmd.assignment.dpa_backend.repository;

import mmd.assignment.dpa_backend.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
