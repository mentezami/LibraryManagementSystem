package com.librarymanagement.libmngsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    @NotBlank(message = "ISBN is a must")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;

    @NotBlank(message = "Title is a must")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;

    @NotBlank(message = "Author is a must")
    @Size(max = 255, message = "Author cannot exceed 255 characters")
    private String author;

    @NotBlank(message = "Publisher is a must")
    @Size(max = 255, message = "Publisher cannot exceed 255 characters")
    private String publisher;

    @NotNull(message = "Publication Year is a must")
    @Min(value = 1900, message = "Publication Year must be after 1900")
    private int publicationYear;

    @NotNull(message = "Genre is a must")
    @Size(max = 100, message = "Genre must be less than 100 characters")
    private String genre;

    @Min(value = 1, message = "NUmber of copies must be at least 1")
    private int numberOfCopies;
}