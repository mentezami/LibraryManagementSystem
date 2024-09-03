package com.librarymanagement.libmngsystem.entity;

import com.librarymanagement.libmngsystem.convertor.JsonbConverter;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import lombok.Data;
import java.util.Map;

@Entity
@Table(name = "members")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "contact_information", nullable = false, columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private Map<String, String> contactInformation;
}