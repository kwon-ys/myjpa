package com.kys.myjpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phonebook")
public class PhoneBookEntity implements IPhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String phoneNumber;
    private String email;

    @Override
    public String toString(){
        return String.format("ID:%6d, 이름:%s, 분류:%s, 번호:%s, 이메일:%s}",
                this.id, this.name, this.category, this.phoneNumber, this.email);
    }
}
