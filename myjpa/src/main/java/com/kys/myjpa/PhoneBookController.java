package com.kys.myjpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/pb")
public class PhoneBookController {
    private static Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    @Autowired
    private IPhoneBookService<IPhoneBook> phoneBookService;

    @PostMapping
    public ResponseEntity<IPhoneBook> insertPB(PhoneBookDto dto) {
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.insert(dto);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<IPhoneBook>> getAll(){
        try {
            List<IPhoneBook> result = this.phoneBookService.getAllList();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}