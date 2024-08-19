package com.tnsif.pm.cetificate;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CertificateController
{
    @Autowired
    private CertificateService service;

    //Restful API method for retrieval operations

    @GetMapping("/certificate")
    public List<Certificate> list()
    {

        return service.listAll();
    }

    @GetMapping("/certificate/{id}")
    public ResponseEntity<Certificate> get(@PathVariable Integer id)
    {
        try{
            Certificate certificate=service.get(id);
            return new ResponseEntity<Certificate>(certificate, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
        }
    }

    //method for Create Operation
    @PostMapping("/certificate")
    public void add(@RequestBody Certificate certificate)
    {
        service.save(certificate);
    }

    //Method to UPDATE Operation
    @PutMapping("/certificate/{id}")
    public ResponseEntity<?> update(@RequestBody Certificate certificate,@PathVariable Integer id)
    {
      try
      {
          Certificate existCertificate=service.get(id);
          service.save(certificate);
          return new ResponseEntity<>(HttpStatus.OK);

      }catch (NoSuchElementException e)
      {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      }
    }

    //Method to DELETE Operation
    @DeleteMapping("Certificate/{id}")
    public void delete(@PathVariable Integer id)
    {
            service.delete(id);
    }



}
