package com.fm.demo.model;
import jakarta.validation.constraints.*;
public class Tip {
  @NotBlank public String category;
  @Size(min=10, max=2000) public String message;
  public String location;
  @Email public String contactEmail;
}
