package com.tnsif.pm.cetificate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CertificateService
{
    @Autowired
    private CertificateRepository repo;

    public List<Certificate> listAll()
    {
        return repo.findAll();
    }

    public Certificate get(Integer id)
    {
        return repo.findById(id).get();
    }

    public void save(Certificate certificate)
    {
         repo.save(certificate);
    }

    public void delete(Integer id)
    {
        repo.deleteById(id);
    }
}
