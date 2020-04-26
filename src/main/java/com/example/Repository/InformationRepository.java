package com.example.Repository;


import com.example.Dto.InformationDto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author shRstart
 * @date 2020/4/25
 */
public interface InformationRepository extends JpaRepository<InformationDto, Long> {
}
