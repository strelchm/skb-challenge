package ru.strelchm.skb.api.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PhonesResponse
 */
public class PhonesResponse implements Serializable {
  public static final String SERIALIZED_NAME_PHONES = "phones";
  private List<String> phones = null;

  public PhonesResponse() {
  }

  public PhonesResponse addPhonesItem(String phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<String>();
    }
    this.phones.add(phonesItem);
    return this;
  }

   /**
   * Get phones
   * @return phones
  **/
  public List<String> getPhones() {
    return phones;
  }


  public void setPhones(List<String> phones) {
    this.phones = phones;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhonesResponse phonesResponse = (PhonesResponse) o;
    return Objects.equals(this.phones, phonesResponse.phones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhonesResponse {\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

