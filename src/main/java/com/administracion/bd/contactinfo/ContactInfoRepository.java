package com.administracion.bd.contactinfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {
}
