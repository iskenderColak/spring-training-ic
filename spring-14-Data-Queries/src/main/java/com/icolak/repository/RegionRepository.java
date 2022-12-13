package com.icolak.repository;

import com.icolak.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {
    //Display all regions in Canada
    List<Region> findAllByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findAllByCountryContaining(String country);

    //Display all regions with country name includes 'United' in order(region)
    List<Region> findAllByCountryContainingOrderByRegionDesc(String country);

    //Display top 2 regions in United States
    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByCountry(String country);

    List<Region> findTopByCountryContainsOrderByRegion(String country);
}
